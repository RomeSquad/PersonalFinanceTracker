package database

import Transaction
//
interface TransactionsDB {
    fun getTotalBalance(): Double
    fun getTotalIncome(): Double
    fun getTotalExpenses(): Double
}
