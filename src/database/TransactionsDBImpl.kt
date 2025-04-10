package database

import Transaction

class TransactionsDBImpl : TransactionsDB {
    val transactions = mutableListOf<Transaction>()
    var incomes: Double = 0.0
    var totalNetBalance : Double = 0.0
    var totalExpense: Double = 0.0

    override fun getTotalBalance(): Double = totalNetBalance

    override fun getTotalIncome(): Double = incomes

    override fun getTotalExpenses(): Double = totalExpense
}