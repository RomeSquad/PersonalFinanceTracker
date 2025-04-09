package action

import Transaction

class InMemory(val transactions:MutableList<Transaction>) {

    fun deleteTransaction(transaction: Transaction) {
        transactions.remove(transaction)
    }
}