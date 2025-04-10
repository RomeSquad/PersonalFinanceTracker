package test

import database.TransactionsInMemory
import entity.Transaction
import java.time.LocalDate

/*
fun main() {
    checkDeleteTransactionWithObject()
}

fun checkDeleteTransactionWithId(){
    val transactionToDelete = newMockTransaction()

    val inMemory = TransactionsInMemory()

    inMemory.addTransaction(newMockTransaction())
    inMemory.addTransaction(transactionToDelete)
    inMemory.deleteTransaction(transactionToDelete.id)

    if(inMemory.transactions.contains(transactionToDelete)){
        println("failed_ transaction with id = $transactionToDelete wasn't deleted")
    }
    else {
        println("success_ transaction is deleted with id")
    }
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

fun newMockTransaction(): Transaction {
    return Transaction(amount = Math.random(), category = "Travel" , date =  LocalDate.now())
}
*/