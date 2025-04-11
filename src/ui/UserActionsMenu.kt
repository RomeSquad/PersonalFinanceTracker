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
import java.util.*

fun userActionsMenu() {
    welcomeSection()
    optionSection()
}

private fun optionSection() {
    val transactionsManager: TransactionsManager = TransactionsInMemory()
    val balanceReport: Report = BalanceReportImpl(transactionsManager)
    val monthlySummaryReport: Report = MonthlySummaryReport(transactionsManager)
    while (true) {
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
        val input = option.toLowerCase()
        when (input) {
            "a" -> {
                println("add transaction ")

                print("enter amount :")
                val amount: Double = readln().toDouble()

                print("enter type : ")
                val type: TransactionsType = TransactionsType.valueOf(readln())

                print("enter category :")
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

                transactionsManager.addTransaction(
                    Transaction(
                        amount = amount,
                        category = category,
                        transactionsType = type
                    )
                )
            }

            "e" -> {
                println("edit transaction ")
                print("enter id ")
                val input = readln()
                val uuid = UUID.fromString(input)

                print("enter amount :")
                val amount: Double = readln().toDouble()

                print("enter type : ")
                val type: TransactionsType = TransactionsType.valueOf(readln())


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

                transactionsManager.editTransaction(
                    Transaction(
                        amount = amount,
                        category = category,
                        transactionsType = type,
                        id = uuid
                    )
                )
            }

            "v" -> {
                transactionsManager.viewTransactions()

            }

            "d" -> {
                println("delete transaction")
                val input = readln()
                val uuid = UUID.fromString(input)
                transactionsManager.deleteTransaction(uuid)
            }

            "m" -> {
                val report = monthlySummaryReport.generateReport()
                println(report)

            }

            "r" -> {
                val report = balanceReport.generateReport()
                println(report)
            }

            "q" -> {
                println("Thanks")
                break
            }

            else -> {
                println("Invalid Option")
            }

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