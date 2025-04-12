package report

import database.TransactionsManager


class MonthlySummaryReport(private val transactionsManager: TransactionsManager) : Report {
    override fun generateReport(): String {
        val data = transactionsManager.getAllTransactions()

        if (data.isEmpty()) {
            return "No transactions found"
        }

        val reportBuilder = StringBuilder()
        reportBuilder.append("Transactions Monthly List:\n")

        data.forEach { transaction ->
            reportBuilder.append("• Date: ${transaction.date} | Amount: ${transaction.amount} | type :${transaction.transactionsType} | Description: ${transaction.category}\n")
        }

        return reportBuilder.toString()
    }
}

