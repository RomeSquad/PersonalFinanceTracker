
import java.time.LocalDate
import java.util.*

fun main() {

}
// Add transaction model with amount and date validation
data class Transaction(
    val id: UUID = UUID.randomUUID(),
    val amount: Double,
    val category: String,
    val date: LocalDate,

) {
    fun validAmount(): Boolean {
    val result = amount > 0
    println(
        when (result) {
            true -> "Checking amount: $amount → Valid"
            false -> "Checking amount: $amount → Invalid"
        }
    )
    return result
}
    fun validDate(): Boolean {
        val result = !date.isAfter(LocalDate.now())
        println(
            when (result) {
                true -> "Checking date: $date → Valid"
                false -> "Checking date: $date → Invalid"
            }
        )
        return result
    }
}