package test.managerActionTest

import database.TransactionsInMemory
import entity.Category
import entity.ExpensesCategories
import entity.Transaction
import entity.TransactionsType
import java.time.LocalDate


fun main() {
    checkDeleteTransactionWithId()
    checkDeleteTransactionWithObject()
}

fun checkDeleteTransactionWithId() {
    val transactionToDelete = newMockTransaction()


    val inMemory = TransactionsInMemory()

    inMemory.addTransaction(newMockTransaction())
    inMemory.addTransaction(transactionToDelete)
    inMemory.deleteTransaction(transactionToDelete.id)

    if (inMemory.transactions.contains(transactionToDelete)) {
        println("failed_ transaction with id = $transactionToDelete wasn't deleted")
    } else {
        println("success_ transaction is deleted with id")
    }
}

fun checkDeleteTransactionWithObject() {

    val mockTransactionToDelete = newMockTransaction()
    val mockTransactionToKeep = newMockTransaction()

    val myTransaction = mutableListOf(
        mockTransactionToKeep
    )

    val inMemory = TransactionsInMemory()
    inMemory.addTransaction(
        mockTransactionToDelete
    )

    inMemory.addTransaction(
        mockTransactionToKeep
    )

    inMemory.deleteTransaction(
        mockTransactionToDelete
    )

    println(inMemory.transactions)
    println(myTransaction)
    println(
        test.check(
            name = "transaction DELETED with transaction object",
            expectedResult = inMemory.transactions,
            correctResult = myTransaction
        )
    )
}


fun newMockTransaction(): Transaction {
    return Transaction(
        amount = Math.random(),
        category = Category.Expenses(ExpensesCategories.TRAVEL),
        transactionsType = TransactionsType.EXPENSES,
        date = LocalDate.now()
    )
}
