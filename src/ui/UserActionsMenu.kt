package ui

import database.TransactionsManager
import entity.ExpensesCategories
import entity.IncomeCategories
import entity.Transaction
import entity.TransactionsType
import feature.report.BalanceReportImpl
import feature.report.MonthlySummaryReport
import feature.report.Report
import java.util.*


class UserActionsMenu(private val transactionsManager: TransactionsManager) {

    fun run(){
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
        println("""
        ********************
=== You Have Many Options To Choice ===
        ********************
Add Transaction ->  press letter ( a )
Edit Transaction -> press letter ( e )
View Transaction -> press letter ( v )
Delete Transaction ->  press letter ( d )
Show your monthly summary feature.report ->  press letter ( m )
Show your balance feature.report ->  press letter ( r ) 
Exit the app ->  press letter ( q )
What do you want : 
""")
    }

    private fun addTransaction() {
        println("Add Transaction")
        print("Enter Amount :")
        val amount: Double = readln().toDouble()

        print("Enter Type ( INCOME - EXPENSES ) : ")
        val type: TransactionsType = TransactionsType.valueOf(readln())

        print("Enter Category :")
        val category = when (type) {
            TransactionsType.INCOME -> {
                IncomeCategories.entries.forEach {
                    it.categoryName
                }
                println(IncomeCategories.entries)
                IncomeCategories.valueOf(readln())
            }

            TransactionsType.EXPENSES -> {
                println(ExpensesCategories.entries)
                ExpensesCategories.valueOf(readln())
            }
        }


        val add = Transaction(amount = amount, category = category, transactionsType = type)
        transactionsManager.addTransaction(add)

        println("Transaction added!")
    }
    private fun editTransaction(){
        println("Edit Transaction ")
        println("Enter Id  Option ")
        getIdTransaction()
        val input = readln()
        val uuid = UUID.fromString(input)

        print("Enter Amount :")
        val amount: Double = readln().toDouble()

        print("Enter Type ( INCOME - EXPENSES ) : ")
        val type: TransactionsType = TransactionsType.valueOf(readln())

        print("Enter Category :")
        val category = when (type) {
            TransactionsType.INCOME -> {
                IncomeCategories.entries.forEach {
                    it.categoryName
                }
                println(IncomeCategories.entries)
                IncomeCategories.valueOf(readln())
            }

            TransactionsType.EXPENSES -> {
                println(ExpensesCategories.entries)
                ExpensesCategories.valueOf(readln())
            }
        }

        val updated = Transaction(uuid,amount,type,category)
        //Check updated
        check(transactionsManager.editTransaction(updated))
    }
    private fun viewTransactions(){
        transactionsManager.viewTransactions()
    }
    private fun deleteTransaction(){

        println("Delete Transaction")
        println("Enter Id  Option ")
        getIdTransaction()

        val idInput = readln()
        val uuid = UUID.fromString(idInput)

        //Check delete
        check(transactionsManager.deleteTransaction(uuid))
    }
    private fun monthlySummaryReport(){

        val monthlySummaryReport: Report = MonthlySummaryReport(transactionsManager)

        println("MonthlyReport")
        val report = monthlySummaryReport.generateReport()
        println(report)
    }
    private fun balanceReport(){
        val balanceReport: Report = BalanceReportImpl(transactionsManager)
        println("BalanceReport")
        val report = balanceReport.generateReport()
        println(report)
    }
    private fun getIdTransaction(){
        print("IDTransactions: ")
        transactionsManager.getAllTransactions().forEach{
            print("${it.id} | ")
        }
        println("\n")
    }

    private fun check(data: Boolean) {
        if (data) println("Transaction Ok")
        else println("Transaction not found.")
    }



}