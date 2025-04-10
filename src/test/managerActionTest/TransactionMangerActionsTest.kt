package test.managerActionTest

import Transaction
import manager.TransactionManger

class TransactionMangerActionsTest : TransactionManger {

    override fun editTransaction(transaction: Transaction): Boolean {
        return false
    }
}