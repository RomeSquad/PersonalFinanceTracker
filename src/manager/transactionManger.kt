package manager

import Transaction


interface TransactionManger {
    fun editTransaction(transaction: Transaction): Boolean
}
