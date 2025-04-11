package ui

import entity.Transaction

fun printTransaction(transaction: Transaction) {
    println("====================")
    println(
        """
            Amount: ${transaction.amount}
            Category: ${transaction.category}
            Date: ${transaction.date}
        """.trim()
    )
    println("====================")
}