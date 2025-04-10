package manager

import Transaction

class TransactionMangerImpl : TransactionManger {
    private val transactions = mutableListOf<Transaction>()

    override fun editTransaction(transaction: Transaction): Boolean {
        val transactionIndex = transactions.indexOf(transaction)
        return if (transactionIndex != -1) {
            transactions[transactionIndex] = transaction
            true
        } else
            false
    }

}