package database

import entity.Transaction
import java.util.*

class TransactionsInJsonSerialization : TransactionsManager {
    override fun addTransaction(transaction: Transaction) {
        val transactions = JsonHelper.readTransactions()
        transactions.add(transaction)
        JsonHelper.writeTransactions(transactions)
    }

    override fun deleteTransaction(transactionID: UUID): Boolean {
        val transactions = JsonHelper.readTransactions()
        val updatedTransactions = transactions.filter { it.id != transactionID }
        JsonHelper.writeTransactions(updatedTransactions)
        return transactions.any { it.id == transactionID }
    }

    override fun viewTransactions() {
        val transactions = JsonHelper.readTransactions()
        transactions.forEach { transaction ->
            println(transaction)
        }
    }


    override fun getAllTransactions(): List<Transaction> {
        return JsonHelper.readTransactions()
    }

    override fun editTransaction(transaction: Transaction): Boolean {
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