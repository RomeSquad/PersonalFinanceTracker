package feature.report

import database.TransactionsManager
import java.text.NumberFormat

class BalanceReportImpl (private  val transactionsManager: TransactionsManager): Report{
    override fun generateReport(): String {
        val totalIncome = transactionsManager.getTotalIncome()
        val formattedIncome = NumberFormat.getCurrencyInstance().format(totalIncome)
        val totalExpense = transactionsManager.getTotalExpenses()
        val formattedExpense = NumberFormat.getCurrencyInstance().format(totalExpense)
        val netBalance = transactionsManager.getTotalIncome()
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