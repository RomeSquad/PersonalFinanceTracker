package database

import entity.Transaction
import java.util.*

class TransactionsInJsonSerialization : TransactionsManager {
    override fun addTransaction(transaction: Transaction) {
        TODO("Not yet implemented")
    }

    override fun deleteTransaction(transactionID: UUID): Boolean {
        TODO("Not yet implemented")
    }

    override fun viewTransactions() {
        TODO("Not yet implemented")
    }


    override fun getAllTransactions(): List<Transaction> {
        TODO("Not yet implemented")
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