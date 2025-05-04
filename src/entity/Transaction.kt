package entity

import java.time.LocalDate
import java.util.*

data class Transaction(
    val id: UUID = UUID.randomUUID(),
    val amount: Double,
    val transactionsType: TransactionsType,
    val category: Category,
    val date: LocalDate = LocalDate.now(),
) {
}