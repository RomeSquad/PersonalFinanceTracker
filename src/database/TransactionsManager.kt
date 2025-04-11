package database

import entity.Transaction
import java.util.UUID

interface TransactionsManager {
    fun addTransaction(transaction: Transaction)
    fun deleteTransaction(transactionID: UUID):Boolean
    fun viewTransactions()
    fun getAllTransactions() :List<Transaction>
    fun editTransaction(transaction: Transaction)

    fun getTotalBalance(): Double
    fun getTotalIncome(): Double
    fun getTotalExpenses(): Double
}
