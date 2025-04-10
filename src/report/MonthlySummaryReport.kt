package report

import database.TransactionsDB


class MonthlySummaryReport(private val dataBase: TransactionsDB) : report {
    override fun generateReport(): String {
        val data = dataBase.getTransctions()

        if (data.isEmpty()) {
            return "No transactions found."
        }

        val reportBuilder = StringBuilder()
        reportBuilder.append("Transactions List:\n")

        data.forEach { transaction ->
            reportBuilder.append("• Date: ${transaction.date} | Amount: ${transaction.amount} | Description: ${transaction.category}\n")
        }

        return reportBuilder.toString()
    }
}
