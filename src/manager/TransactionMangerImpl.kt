package manager

import Transaction

class TransactionMangerImpl : TransactionManger {
    private val transactions = mutableListOf<Transaction>()
    override fun editTransaction(transaction: Transaction): Boolean {

        val index = transactions.indexOfFirst { it.id == transaction.id }
        return if (index != -1) {
            transactions[index] = transaction
            true
        } else {
            false
        }
    }

}