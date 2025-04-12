package database

import entity.Transaction
import entity.TransactionJson
import entity.mapper.toTransaction
import entity.mapper.toTransactionJson
import kotlinx.serialization.json.Json
import java.io.File

object JsonHelper {
    val FILE_PATH = "transactions.json"
    val json = Json {
        prettyPrint = true
    }

    fun readTransactions(): MutableList<Transaction> {
        val file = File(FILE_PATH)
        if (!file.exists()) return mutableListOf()
        val content = file.readText()
        return if (content.isNotBlank()) {
            json.decodeFromString<MutableList<TransactionJson>>(content).map {it.toTransaction()  }.toMutableList()
        } else mutableListOf<TransactionJson>().map { it.toTransaction() }.toMutableList()
    }

    fun writeTransactions(transactions: List<Transaction>) {
        File(FILE_PATH).writeText(json.encodeToString(transactions.map { it.toTransactionJson() }))
    }

}