package entity

import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class TransactionJson(
    val id: String,
    val amount: Double,
    val transactionsType: TransactionsType,
    val category: Category,
    val date: String = LocalDate.now().toString(),
)