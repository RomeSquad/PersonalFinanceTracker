package database

import entity.Transaction

class TransactionsInJsonSerialization: TransactionsManager {

    override fun addTransaction(transaction: Transaction) {
        TODO("Not yet implemented")
    }

    override fun deleteTransaction(transaction: Transaction) {
        TODO("Not yet implemented")
    }

    override fun getTransaction(transactionId: String): Transaction? {
        TODO("Not yet implemented")
    }

    override fun getAllTransactions(): List<Transaction> {
        TODO("Not yet implemented")
    }

    override fun editTransaction(transaction: Transaction) {
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