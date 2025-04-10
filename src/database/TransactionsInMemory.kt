package database

import entity.Transaction
import entity.TransactionsType
import java.util.UUID


class TransactionsInMemory : TransactionsManager {
    val transactions = mutableListOf<Transaction>()

    override fun addTransaction(transaction: Transaction) { //TODO : Zinah

        transactions.add(transaction)
    }

    override fun deleteTransaction(transactionID: UUID) {
        transactions.remove(transactions.find { it.id == transactionID })
    }

    fun deleteTransaction(transaction: Transaction) {
        transactions.remove(transaction)
    }


//    override fun getAllTransactions() : List<Tra> {
//        if (transactions.isEmpty()) {
//            println("No transactions found. \nTo add a new transaction, please go to the main menu and select 'Add'.")
//        } else {
//            transactions.forEach { transaction ->
//                viewTransaction(transaction)
//            }
//        }
//    }

    override fun getAllTransactions(): List<Transaction> {

        return transactions
    }

    override fun editTransaction(transaction: Transaction) {//TODO : Abanoub
        TODO("Not yet implemented")
    }

    override fun getTotalBalance(): Double {
        return transactions.map { if (it.transactionsType == TransactionsType.INCOME) it.amount else it.amount.unaryMinus() }
            .sum()
    }

    override fun getTotalIncome(): Double {
        return transactions.filter { it.transactionsType == TransactionsType.INCOME }.map { it.amount }.sum()
    }

    override fun getTotalExpenses(): Double {
        return transactions.filter { it.transactionsType == TransactionsType.EXPENSES }.map { it.amount }.sum()
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