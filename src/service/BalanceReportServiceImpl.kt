package service

import data.model.report.BalanceReport
import repository.TransactionRepository

class BalanceReportServiceImpl(private val transactionRepository: TransactionRepository) : ReportService<BalanceReport> {
    override fun generateReport(): BalanceReport {
        return BalanceReport(
            netBalance = transactionRepository.fetchCurrentBalance(),
            totalIncome = transactionRepository.fetchTotalIncome(),
            totalExpense = transactionRepository.fetchTotalExpense(),
        )
    }
}
