package report

import database.TransactionsDB
import java.text.NumberFormat

class BalanceReport (private val transactionsDB: TransactionsDB): report{
    override fun generateReport(): String {
        val totalIncome = transactionsDB.getTotalIncome()
        val formattedIncome = NumberFormat.getCurrencyInstance().format(totalIncome)
        val totalExpense = transactionsDB.getTotalExpenses()
        val formattedExpense = NumberFormat.getCurrencyInstance().format(totalExpense)
        val netBalance = transactionsDB.getTotalIncome()
        val formattedBalance = NumberFormat.getCurrencyInstance().format(netBalance)

        return """
            |=================================
            |          BALANCE REPORT         
            |=================================
            |Total Income:  $${formattedIncome}
            |Total Expense: $${formattedExpense}
            |--------------------------------
            |Net Balance:   $${formattedBalance}
            |=================================
        """.trimMargin()
    }

}