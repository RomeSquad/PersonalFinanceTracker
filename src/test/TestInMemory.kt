package test

import database.TransactionsInMemory
import entity.Transaction
import java.time.LocalDate


fun main() {
    checkDeleteTransactionWithObject()
}

fun checkDeleteTransactionWithObject() {

    val myTransaction = mutableListOf(
        Transaction(amount = 100.0, category = "Travel", date = LocalDate.of(2030, 12, 20))
    )

    val inMemory = TransactionsInMemory()
    inMemory.addTransaction(Transaction(amount = 100.0, category = "Travel", date = LocalDate.of(2000, 11, 20)))
    inMemory.addTransaction(Transaction(amount = 100.0, category = "Travel", date = LocalDate.of(2030, 12, 20)))

    inMemory.deleteTransaction(Transaction(amount = 100.0, category = "Travel", date = LocalDate.of(2000, 11, 20)))
    checkTransaction(
        case = "transaction DELETED with transaction object",
        reterned_Result = inMemory.transactions,
        correctResult = myTransaction
    )
}


fun checkTransaction(case: String, reterned_Result: MutableList<Transaction>, correctResult: MutableList<Transaction>) {
    if (reterned_Result == correctResult) {
        println("success_ ")
    } else {
        println("failed_ ")
    }
}
