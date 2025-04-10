package database

import entity.Transaction

interface TransactionsManager {
    fun addTransaction(transaction: Transaction)
    fun deleteTransaction(transaction: Transaction)
    fun getTransaction(transaction: Transaction)
    fun getAllTransactions(transactions: List<Transaction>)
    fun editTransaction(transaction: Transaction)

    fun getTotalBalance(): Double
    fun getTotalIncome(): Double
    fun getTotalExpenses(): Double
}
