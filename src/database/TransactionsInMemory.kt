package database

import entity.Transaction


class TransactionsInMemory : TransactionsManager {
    val transactions = mutableListOf<Transaction>()

    override fun addTransaction(transaction: Transaction) { //TODO : Zinah
        TODO("Not yet implemented")
    }

    override fun deleteTransaction(transaction: Transaction) {
        transactions.remove(transaction)
    }

    override fun getTransaction(transaction: Transaction) {
        val searchedTransaction = transactions.find { it.id == transaction.id }
        if (searchedTransaction != null) {
            viewTransaction(searchedTransaction)
        } else {
            println("Transaction not found for this ID")
        }
    }

    override fun getAllTransactions(transactions: List<Transaction>) {
        if (transactions.isEmpty()) {
            println("No transactions found. \nTo add a new transaction, please go to the main menu and select 'Add'.")
        } else {
            transactions.forEach { transaction ->
                viewTransaction(transaction)
            }
        }
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

    private fun viewTransaction(transaction: Transaction) {
        println("====================")
        println(
            """
            ID: ${transaction.id}
            Amount: ${transaction.amount}
            Category: ${transaction.category}
            Date: ${transaction.date}
            """
        )
        println("====================")
    }
}