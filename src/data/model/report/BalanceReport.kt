package data.model.report

import java.text.NumberFormat

data class BalanceReport(
    val netBalance :Double,
    val totalIncome :Double,
    val totalExpense :Double,

){
    override fun toString(): String {
        val formattedIncome = NumberFormat.getCurrencyInstance().format(totalIncome)
        val formattedExpense = NumberFormat.getCurrencyInstance().format(totalExpense)
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