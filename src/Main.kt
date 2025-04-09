import java.time.LocalDate
// Run transaction validation checks
fun main() {
    val validTransaction = Transaction(
        amount = 120.0,
        category = "Salary",
        date = LocalDate.now()
    )

    val invalidTransaction = Transaction(
        amount = -40.0,
        category = "",
        date = LocalDate.now().plusDays(3)
    )

    println("Valid Transaction:$validTransaction ")



    println("Invalid Transaction:$invalidTransaction")


}