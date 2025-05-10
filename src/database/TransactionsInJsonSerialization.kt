package database

import entity.Transaction
import entity.TransactionsType
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
        val transactions = JsonHelper.readTransactions()
        if (!transactions.removeIf { it.id == transaction.id })
            return false
        transactions.add(transaction)
        JsonHelper.writeTransactions(transactions)
        return true
    }

    override fun getTotalBalance(): Double {
        val transactions = JsonHelper.readTransactions()
        return transactions.map { if (it.transactionsType == TransactionsType.INCOME) it.amount else it.amount.unaryMinus() }
            .sum()
    }

    override fun getTotalIncome(): Double {
        val transactions = JsonHelper.readTransactions()
        return transactions.filter { it.transactionsType == TransactionsType.INCOME }.map { it.amount }.sum()
    }

    override fun getTotalExpenses(): Double {
        val transactions = JsonHelper.readTransactions()
        return transactions.filter { it.transactionsType == TransactionsType.EXPENSES }.map { it.amount }.sum()
    }


}