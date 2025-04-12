package entity.mapper

import entity.Transaction
import entity.TransactionJson
import java.time.LocalDate
import java.util.*

fun TransactionJson.toTransaction(): Transaction {
    return Transaction(
        id = UUID.fromString(this.id),
        amount = this.amount,
        transactionsType = this.transactionsType,
        category = this.category,
        date = LocalDate.parse(this.date),
    )
}
fun Transaction.toTransactionJson(): TransactionJson {
    return TransactionJson(
        id = this.id.toString(),
        amount = this.amount,
        transactionsType = this.transactionsType,
        category = this.category,
        date = this.date.toString(),
    )
}