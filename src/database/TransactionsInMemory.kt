package database

import entity.Transaction
import java.util.UUID


class TransactionsInMemory : TransactionsManager {
    val transactions = mutableListOf<Transaction>()

    override fun addTransaction(transaction: Transaction) { //TODO : Zinah
        TODO("Not yet implemented")
    }

    override fun deleteTransaction(transactionID: UUID) {
        transactions.remove(transactions.find { it.id == transactionID })
    }

    override fun deleteTransaction(transaction: Transaction) {
        transactions.remove(transaction)
    }

    override fun getTransaction(transactionId: String): Transaction? { //TODO : Mo Ramadan
        TODO("Not yet implemented")
    }

    override fun getAllTransactions(): List<Transaction> {//TODO : Mo Ramadan
        TODO("Not yet implemented")
    }

    override fun editTransaction(transaction: Transaction) {//TODO : Abanoub
        TODO("Not yet implemented")
    }

    override fun getTotalBalance(): Double {
        TODO("Not yet implemented")
    }

    override fun getTotalIncome(): Double {
        TODO("Not yet implemented")
    }

    override fun getTotalExpenses(): Double {
        TODO("Not yet implemented")
    }
}