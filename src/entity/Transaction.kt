package entity

import java.time.LocalDate
import java.util.*

data class Transaction(
    val id: UUID = UUID.randomUUID(),
    val amount: Double,
    val transactionsType:TransactionsType,
    val  ICategory:ICategory,
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

    override fun toString(): String {
        return "Transaction(id=$id, amount=$amount, category='$ICategory', date=$date)"
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