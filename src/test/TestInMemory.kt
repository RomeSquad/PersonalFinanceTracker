package test

import database.TransactionsInMemory
import entity.Categories
import entity.Transaction
import entity.TransactionsType
import java.time.LocalDate



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
        Transaction(amount = 100.0,
            category = Categories.SHOPPING ,
            transactionsType = TransactionsType.EXPENSES,
            date = LocalDate.of(2030, 12, 20))
    )

    val inMemory = TransactionsInMemory()
    inMemory.addTransaction(Transaction(amount = 100.0,
        category =Categories.RENT
        ,transactionsType =  TransactionsType.INCOME,
        date = LocalDate.of(2000, 11, 20))
    )

    inMemory.addTransaction(Transaction(amount = 100.0,
        category =Categories.TRAVEL,
        transactionsType = TransactionsType.EXPENSES ,
        date = LocalDate.of(20230, 12, 20)))

    inMemory.deleteTransaction(Transaction(amount = 100.0,
        category = Categories.TRAVEL,
        transactionsType = TransactionsType.EXPENSES,
        date = LocalDate.of(2000, 11, 20)))
    checkTransaction(
        name = "transaction DELETED with transaction object",
        expectedResult = inMemory.transactions,
        correctResult = myTransaction
    )
}

fun checkTransaction(name: String, expectedResult: MutableList<Transaction>, correctResult: MutableList<Transaction>) {
    if (expectedResult == correctResult) {
        println("success_ ")
    } else {
        println("failed_ ")
    }
}

fun newMockTransaction(): Transaction {
    return Transaction(amount = Math.random(), category =  Categories.TRAVEL, transactionsType =TransactionsType.EXPENSES , date =  LocalDate.now())
}
