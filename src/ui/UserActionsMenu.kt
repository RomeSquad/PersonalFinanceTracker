package ui

import database.TransactionsInMemory
import database.TransactionsManager
import entity.ExpensesCategories
import entity.IncomeCategories
import entity.Transaction
import entity.TransactionsType
import report.BalanceReportImpl
import report.MonthlySummaryReport
import report.Report
import java.time.LocalDate
import java.time.Month
import java.time.format.DateTimeFormatter

fun userActionsMenu() {
    welcomeSection()
    optionSection()
}

private fun optionSection() {
    println("************* ")
    println("you have many options to choice")
    println("************* ")

    println("Add Transaction ->  press letter ( a ) ")
    println("Edit Transaction -> press letter ( e )")
    println("View Transaction -> press letter ( v )  ")
    println("Delete Transaction ->  press letter ( d ) ")
    println("Show your monthly summary report ->  press letter ( m ) ")
    println("Show your balance report ->  press letter ( r )  ")
    println("Exit the app ->  press letter ( q ) ")

    print("what do you want : ")
    val option: String = readln()


    val transactionsManager: TransactionsManager = TransactionsInMemory()
    val balanceReport :Report = BalanceReportImpl(transactionsManager)

    when (option) {
        "a" -> {


            println("add transaction ")

            print("enter amount :")
            val amount: Double = readln().toDouble()

            print("enter type : ")
            val type:TransactionsType = TransactionsType.valueOf(readln())


            print("enter category :")
            when(type){
                TransactionsType.INCOME ->  {
                    IncomeCategories.entries.forEach{
                        it.categoryName
                    }
                    println(IncomeCategories.entries)
                    IncomeCategories.valueOf(readln())
                }
                TransactionsType.EXPENSES -> {
                    println(IncomeCategories.entries)
                    ExpensesCategories.valueOf(readln())
                }
            }


//            transactionsManager.addTransaction(
//                Transaction(
//                    amount = amount,
//                    category = IncomeCategories.OTHER,
//                    transactionsType = type,
//
//                )
//            )
//            print("enter date (yyyy-mm-dd) : ")
//            val date = LocalDate.parse(readln(), DateTimeFormatter.ISO_DATE)



        }

        "e" -> {


            println("edit transaction ")
            print("enter id ")
            val id = readln()

            print("enter amount :")
            val amount: Double = readln().toDouble()

            print("enter type : ")
            val type:TransactionsType = TransactionsType.valueOf(readln())


            print("enter category :")
            when(type){
                TransactionsType.INCOME ->  {
                    println(IncomeCategories.entries)
                    IncomeCategories.valueOf(readln())
                }
                TransactionsType.EXPENSES -> {
                    println(IncomeCategories.entries)
                    ExpensesCategories.valueOf(readln())
                }
            }

            print("enter date (yyyy-mm-dd) : ")
            val date = LocalDate.parse(readln(), DateTimeFormatter.ISO_DATE)


//            transactionsManager.editTransaction(
//                Transaction(
//                    amount = amount,
//                    category = category,
//                    transactionsType = type,
//                    date = date
//                )
//            )

        }

        "v" -> {
            transactionsManager.viewTransactions()

        }

        "d" -> {
            // TODO call delete fun
            // print("enter now type :")
            // val id = readln()
            // transactionsManager.deleteTransaction(id)
        }

        "m" -> {
            // TODO call monthly report fun
            // MonthlySummaryReport(transactionsManager)

        }

        "r" -> {
            val  report = balanceReport.generateReport()
            println(report)
        }

        "q" -> {
            println("Thanks")
        }

        else -> {
            println("Invalid Option")
        }

    }
}

private fun welcomeSection() {
    println("************* ")
    println("Welcome to your Finance Tracker App ")
    println("************* ")

    print("Please enter your name :  ")
    val name: String = readln()
    println("************* ")
    println("Welcome $name ")
}