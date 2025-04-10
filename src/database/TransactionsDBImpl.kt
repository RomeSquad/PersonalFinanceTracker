package database

import Transaction

class TransactionsDBImpl : TransactionsDB {
    val transactions = mutableListOf<Transaction>()
    var totalIncome: Double = 0.0
    var totalNetBalance : Double = 0.0
    var totalExpense: Double = 0.0

    override fun getTotalBalance(): Double = totalNetBalance

    override fun getTotalIncome(): Double = totalIncome

    override fun getTotalExpenses(): Double = totalExpense
}