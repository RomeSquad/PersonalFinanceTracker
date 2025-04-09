
import data.model.report.BalanceReport
import repository.TransactionRepository
import service.BalanceReportServiceImpl

class MockTransactionsRepository : TransactionRepository {
    override fun fetchCurrentBalance(): Double {
        return 50.0
    }

    override fun fetchTotalIncome(): Double {
        return 100.0
    }

    override fun fetchTotalExpense(): Double {
        return 50.0
    }

}

fun check(description: String, result: Any, correctResult: Any) {
    println(description)
    val resultString = if (result == correctResult) "PASS" else "FAIL"
    println("result = \n$result")
    println("correctResult =\n $correctResult")
    println("Result: $resultString")
    println()
}

fun main() {
    val repository = MockTransactionsRepository()
    val reportService = BalanceReportServiceImpl(repository)
    val balanceReport = reportService.generateReport()
    check(
        "test generate balance report fun",
        result = balanceReport,
        correctResult = BalanceReport(50.0,100.0,50.0)

    )

}

