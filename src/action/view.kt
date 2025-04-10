package action

import Transaction

fun view(transaction: Transaction) {
    println("====================")
    println("ID: ${transaction.id}")
    println("Amount: ${transaction.amount}")
    println("Category: ${transaction.category}")
    println("Date: ${transaction.date}")
}