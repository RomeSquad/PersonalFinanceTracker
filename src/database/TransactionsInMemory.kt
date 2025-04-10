package database

import entity.Transaction


class TransactionsInMemory : TransactionsManager {
    val transactions = mutableListOf<Transaction>()

    override fun addTransaction(transaction: Transaction) { //TODO : Zinah

        transactions.add(addTransaction)
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