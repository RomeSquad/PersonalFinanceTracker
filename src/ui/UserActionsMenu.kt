package ui

import database.TransactionsManager
import entity.*
import report.BalanceReportImpl
import report.MonthlySummaryReport
import report.Report
import java.util.*


class UserActionsMenu(private val transactionsManager: TransactionsManager) {

    fun run() {
        welcomeSection()
        while (true) {
            printOptions()
            when (readln().lowercase()) {
                "a" -> addTransaction()
                "e" -> editTransaction()
                "v" -> viewTransactions()
                "d" -> deleteTransaction()
                "m" -> monthlySummaryReport()
                "r" -> balanceReport()
                "q" -> {
                    println("Thanks")
                    break
                }

                else -> println("Invalid Option")
            }

            print("Do you want to perform another action? (y/n): ")
            val continueChoice = readln().lowercase()
            if (continueChoice != "y") {
                println("Goodbye 👋")
                break
            }
        }
    }

    private fun welcomeSection() {
        println("************* ")
        println("Welcome to your Finance Tracker App ")
        println("************* ")

        var name: String

        do {
            print("Please enter your name: ")
            name = readln().trim()

            if (name.isEmpty()) {
                println("⚠️ Name IsEmpty. Please try again.")
            }
        } while (name.isEmpty())

        println("*************")
        println("Welcome $name")

    }

    private fun printOptions() {
        print(
            """
        ********************
=== You Have Many Options To Choice ===
        ********************
Add Transaction ->  press letter ( a )
Edit Transaction -> press letter ( e )
View Transaction -> press letter ( v )
Delete Transaction ->  press letter ( d )
Show your monthly summary report ->  press letter ( m )
Show your balance report ->  press letter ( r ) 
Exit the app ->  press letter ( q )
What do you want : """
        )
    }
    private fun addTransaction() {
        println("Add Transaction")
        val (amount, type, category) = getTransactionInput()

        val add = Transaction(amount = amount, category = category, transactionsType = type)
        transactionsManager.addTransaction(add)

        println("Transaction added!")
    }

    private fun editTransaction() {
        println("=== Edit Transaction ===")
        println("Select a transaction to edit:")

        val transactionsList = transactionsManager.getAllTransactions()

        transactionsList.forEachIndexed { index, transaction ->
            println("[ ${index + 1} - Transaction ${transaction.amount}, ${transaction.transactionsType}, ${transaction.category.categoryName} ]")
        }

        print("Enter transaction number to edit: ")
        val selectedNumber = readln().trim().toIntOrNull()

        if (selectedNumber == null || selectedNumber !in 1..transactionsList.size) {
            println("Invalid selection.")
            return
        }


        val selectedTransaction = transactionsList[selectedNumber - 1]
        val selectedId = selectedTransaction.id


        val (amount, type, category) = getTransactionInput()
        val updated = Transaction(
            id = selectedId,
            amount = amount,
            transactionsType = type,
            category = category
        )
        transactionsManager.editTransaction(updated)


    }

    private fun viewTransactions() {
        if (transactionsManager.getAllTransactions().isNotEmpty()) {
            transactionsManager.getAllTransactions().forEachIndexed() { index, transaction ->
                println(
                    """-------------------------------
            ${index + 1}-Transactions
            Amount: ${transaction.amount}
            Category: ${transaction.category}
            Date: ${transaction.date}
            --------------------------------"""
                )
            }
        } else {
            println("View Transactions List Empty.")
        }


    }

    private fun deleteTransaction() {

        println("=== DeleteTransaction ===")
        println("Select a transaction to delete:")
        val transactionsList = transactionsManager.getAllTransactions()

        transactionsList.forEachIndexed { index, transaction ->
            println("[ ${index + 1} - Transaction ${transaction.amount}, ${transaction.transactionsType}, ${transaction.category.categoryName} ]")
        }

        print("Enter transaction number to delete: ")
        val selectedNumber = readln().trim().toIntOrNull()

        if (selectedNumber == null || selectedNumber !in 1..transactionsList.size) {
            println("Invalid selection.")
            return
        }


        val selectedTransaction = transactionsList[selectedNumber - 1]
        val selectedId = selectedTransaction.id

        //Check delete
        check(transactionsManager.deleteTransaction(selectedId),"Deleted")
    }

    private fun monthlySummaryReport() {

        val monthlySummaryReport: Report = MonthlySummaryReport(transactionsManager)

        val report = monthlySummaryReport.generateReport()
        println(report)
    }

    private fun balanceReport() {
        val balanceReport: Report = BalanceReportImpl(transactionsManager)
        val report = balanceReport.generateReport()
        println(report)
    }

    fun getTransactionInput(): Triple<Double, TransactionsType, ICategory> {

        var amount: Double? = null

        do {
            print("Enter amount: ")
            val input = readln().trim()

            amount = input.toDoubleOrNull()

            if (amount == null) {
                println("Invalid amount. Please enter a numeric value.")
            } else if (amount <= 0) {
                println("Amount must be greater than zero.")
                amount = null
            }

        } while (amount == null)


        var type: TransactionsType? = null

        do {
            print(
                """
**********************************************
=== Enter Typ You Have Many Options To Choice ===
**********************************************
 Enter Type
INCOME Enter -> 1
EXPENSES Enter -> 2
 What do you want : """
            )
            val input = readln().trim()

            if (input == "1") {
                type = TransactionsType.INCOME
            } else if (input == "2") {
                type = TransactionsType.EXPENSES
            } else {
                println("Invalid input. Please enter only 1 or 2 .")
            }
        } while (type == null)

        val category = when (type) {
            TransactionsType.INCOME -> {
                var selected: IncomeCategories? = null
                do {
                    println("Available income categories:")
                    IncomeCategories.entries.forEachIndexed { index, category ->
                        println("${index + 1} - ${category.categoryName}")
                    }

                    print("Choose number: ")
                    val input = readln().trim()

                    if (input == "1") selected =
                        IncomeCategories.entries.find { it.categoryName.lowercase() == "salary" }
                    else if (input == "2") selected =
                        IncomeCategories.entries.find { it.categoryName.lowercase() == "freelance" }
                    else if (input == "3") selected =
                        IncomeCategories.entries.find { it.categoryName.lowercase() == "business" }
                    else if (input == "4") selected =
                        IncomeCategories.entries.find { it.categoryName.lowercase() == "other" }
                    if (selected == null) {
                        println("Invalid category. Please choose from the list.")
                    }
                } while (selected == null)
                selected
            }

            TransactionsType.EXPENSES -> {
                var selected: ExpensesCategories? = null
                do {
                    println("Available expense categories:")
                    ExpensesCategories.entries.forEachIndexed { index, category ->
                        println("${index + 1} - ${category.categoryName}")
                    }

                    print("Choose one: ")
                    val input = readln().trim()

                    if (input == "1") selected =
                        ExpensesCategories.entries.find { it.categoryName.lowercase() == "shopping" }
                    else if (input == "2") selected =
                        ExpensesCategories.entries.find { it.categoryName.lowercase() == "travel" }
                    else if (input == "3") selected =
                        ExpensesCategories.entries.find { it.categoryName.lowercase() == "food" }
                    else if (input == "4") selected =
                        ExpensesCategories.entries.find { it.categoryName.lowercase() == "rent" }
                    else if (input == "5") selected =
                        ExpensesCategories.entries.find { it.categoryName.lowercase() == "gifts" }
                    else if (input == "6") selected =
                        ExpensesCategories.entries.find { it.categoryName.lowercase() == "bills" }
                    else if (input == "7") selected =
                        ExpensesCategories.entries.find { it.categoryName.lowercase() == "transportation" }
                    else if (input == "8") selected =
                        ExpensesCategories.entries.find { it.categoryName.lowercase() == "entertainment" }
                    else if (input == "9") selected =
                        ExpensesCategories.entries.find { it.categoryName.lowercase() == "personal needs" }
                    else if (input == "10") selected =
                        ExpensesCategories.entries.find { it.categoryName.lowercase() == "other" }
                    else {
                        println("Invalid category. Please choose from the list.")
                    }
                    if (selected == null) {
                        println("Invalid category. Please choose from the list.")
                    }


                } while (selected == null)
                selected
            }
        }


        return Triple(amount, type, category)
    }


    private fun check(data: Boolean,tpye: String) {
        if (data) println("Transaction ${tpye}")
        else println("Transaction not found.")
    }


}