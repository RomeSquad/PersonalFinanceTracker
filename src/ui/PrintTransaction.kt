package ui

import entity.Transaction

fun printTransaction(transaction: Transaction) {
    println("====================")
    println(
        """
            ID: ${transaction.id}
            Amount: ${transaction.amount}
            Category: ${transaction.category}
            Date: ${transaction.date}
            """
    )
    println("====================")
}