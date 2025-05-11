package database

import entity.Transaction
import entity.TransactionsType
import java.util.UUID


class TransactionsInMemory : TransactionsManager {
    val transactions = mutableListOf<Transaction>()

    override fun addTransaction(transaction: Transaction) {
        transactions.add(transaction)
    }

    override fun deleteTransaction(transactionID: UUID): Boolean {
        return transactions.remove(transactions.find { it.id == transactionID })
    }


    override fun getAllTransactions(): List<Transaction> {
        return transactions
    }

    override fun editTransaction(transaction: Transaction): Boolean {
        val index = transactions.indexOfFirst { it.id == transaction.id }
        return if (index != -1) {
            transactions[index] = transaction
            true
        } else {
            false
        }
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

    override fun formatTrasction():Boolean {
        return transactions.removeAll(transactions)
    }


}