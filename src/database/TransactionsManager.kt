package database

import entity.Transaction

interface TransactionsManager {
    fun addTransaction(transaction: Transaction)
    fun deleteTransaction(transaction: Transaction)
    fun getTransaction(transactionId: String) : Transaction?
    fun getAllTransactions(): List<Transaction>
    fun editTransaction(transaction: Transaction): Boolean

    fun getTotalBalance(): Double
    fun getTotalIncome(): Double
    fun getTotalExpenses(): Double
}
