package action

import Transaction

class InMemory(val transactions: MutableList<Transaction>) : UserActions {

    override fun deleteTransaction(transaction: Transaction) {
        transactions.remove(transaction)
    }

    override fun add() {
        TODO("Not yet implemented")
    }
}