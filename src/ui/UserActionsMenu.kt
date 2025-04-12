package ui

import database.TransactionsManager
import entity.*
import report.BalanceReportImpl
import report.MonthlySummaryReport
import report.Report


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
            println("[ ${index + 1} - Transaction ${transaction.amount}, ${transaction.transactionsType}, ${transaction.category} ]")
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
            println("[ ${index + 1} - Transaction ${transaction.amount}, ${transaction.transactionsType}, ${transaction.category} ]")
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
        check(transactionsManager.deleteTransaction(selectedId), "Deleted")
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


    fun getTransactionInput(): Triple<Double, TransactionsType, Category> {


        var amount: Double? = null
        do {
            print("Enter amount: ")
            val input = readln().trim()
            amount = input.toDoubleOrNull()

            if (amount == null || amount <= 0) {
                println("⚠️ Invalid amount. Please enter a positive number.")
                amount = null
            }
        } while (amount == null)

        var type: TransactionsType? = null
        do {
            println(
                """
**********************************************
=== Select Transaction Type ===
1. INCOME
2. EXPENSES
What do you want: 
""".trimIndent()
            )
            when (readln().trim()) {
                "1" -> type = TransactionsType.INCOME
                "2" -> type = TransactionsType.EXPENSES
                else -> println("Invalid input. Please enter only 1 or 2.")
            }
        } while (type == null)

        val category = when (type) {
            TransactionsType.INCOME -> {
                var selected: IncomeCategories? = null
                do {
                    println("Available Income Categories:")
                    IncomeCategories.entries.forEachIndexed { index, cat ->
                        println("${index + 1} - ${cat.categoryName}")
                    }

                    print("Choose number: ")
                    val input = readln().trim().toIntOrNull()

                    selected = if (input != null && input in 1..IncomeCategories.entries.size) {
                        IncomeCategories.entries[input - 1]
                    } else null

                    if (selected == null) {
                        println("Invalid selection. Try again.")
                    }
                } while (selected == null)
                Category.Income(selected)
            }

            TransactionsType.EXPENSES -> {
                var selected: ExpensesCategories? = null
                do {
                    println("Available Expense Categories:")
                    ExpensesCategories.entries.forEachIndexed { index, cat ->
                        println("${index + 1} - ${cat.categoryName}")
                    }

                    print("Choose number: ")
                    val input = readln().trim().toIntOrNull()

                    selected = if (input != null && input in 1..ExpensesCategories.entries.size) {
                        ExpensesCategories.entries[input - 1]
                    } else null

                    if (selected == null) {
                        println("Invalid selection. Try again.")
                    }
                } while (selected == null)
                Category.Expenses(selected)
            }
        }

        return Triple(amount, type, category)
    }


    private fun check(data: Boolean, tpye: String) {
        if (data) println("Transaction ${tpye}")
        else println("Transaction not found.")
    }


}