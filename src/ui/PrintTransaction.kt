package ui

import entity.Transaction

fun printTransaction(transaction: Transaction) {
    println("====================")
    println(
        """
            ID: ${transaction.id}
            Amount: ${transaction.amount}
            Category: ${transaction.ICategory.categoryName}
            Date: ${transaction.date}
            """
    )
    println("====================")
}