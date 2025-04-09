package repository

import data.model.transaction.Transaction
import java.util.*

class TransactionRepositoryImpl : TransactionRepository {
    //TODO :Update the variables in any crud operation
    val transactions = mutableListOf<Transaction>()
    var totalIncome :Double =0.0
    var totalExpense:Double =0.0
    var netBalance : Double = 0.0

    override fun fetchCurrentBalance() = netBalance
    override fun fetchTotalIncome() = totalIncome
    override fun fetchTotalExpense() = totalExpense
}