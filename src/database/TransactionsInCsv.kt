package database

import entity.Transaction
import java.io.File
import java.util.*

class TransactionsInCsv :TransactionsManager {
    val file :File = File ("Transactions.txt")
    override fun addTransaction(transaction: Transaction) {
        file.appendText("$transaction\n")
    }

    override fun deleteTransaction(transactionID: UUID): Boolean {
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