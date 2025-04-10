package ui

import database.TransactionsInMemory
import database.TransactionsManager
import entity.Transaction
import java.time.LocalDate
import java.time.Month

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

    when (option) {
        "a" -> {
            //TODO call add fun

            println("add transaction ")
            print("enter amount :")
            val input = readln()
            print("enter cat :")
            val input2 = readln()
            print("enter type :")
            val input3 = readln()


//            transactionsManager.addTransaction(
//                Transaction(
//                    amount = 25.0, // replace with input
//                    category = "ams",// replace with input2
//                    //type = " "  // replace with type
//                    date = LocalDate.of(2025, Month.JANUARY, 2)
//                )
//            )
        }

        "e" -> {
            //TODO call edit fun

            println("edit transaction ")
            print("enter now amount :")
            val input = readln()
            print("enter now cat :")
            val input2 = readln()
            print("enter now type :")
            val input3 = readln()


            // take id  from user
           // transactionsManager.editTransaction(
            //  amount = 25.0, // replace with input
            //                    category = "ams",// replace with input2
            //                    //type = " "  // replace with type
           // date = LocalDate.of(2025, Month.JANUARY, 2)
            // )

        }

        "v" -> {
            //TODO call view fun
            transactionsManager.getAllTransactions()
           // transactionsManager.getTransaction("535")

        }

        "d" -> {
            //TODO call delete fun

                //     transactionsManager.deleteTransaction(
            //// id
            //            )
        }

        "m" -> {
            // TODO call monthly report fun

        }

        "r" -> {
            // TODO call balance report fun

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