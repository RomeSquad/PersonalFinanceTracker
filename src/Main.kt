import java.time.LocalDate

// Run transaction validation checks
fun main() {
    val validTransaction = Transaction(
        amount = 120.0,
        category = "Salary",
        type = TransactionType.INCOME
    )

    val invalidTransaction = Transaction(
        amount = -40.0,
        category = "",
        type = TransactionType.EXPENSE
    )

    println("Valid Transaction:$validTransaction ")



    println("Invalid Transaction:$invalidTransaction")


}