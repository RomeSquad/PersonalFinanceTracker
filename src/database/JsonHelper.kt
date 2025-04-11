package database

import entity.Transaction
import kotlinx.serialization.json.Json
import java.io.File

object JsonHelper {
    val FILE_PATH = "serialized-transactions/transactions.json"
    val json = Json {
        prettyPrint = true
    }

    fun readTransactions(): MutableList<Transaction> {
        val file = File(FILE_PATH)
        if (!file.exists()) return mutableListOf()
        val content = file.readText()
        return if (content.isNotBlank()) {
            json.decodeFromString(content)
        } else mutableListOf()
    }

    fun writeTransactions(transactions: List<Transaction>) {
        File(FILE_PATH).writeText(json.encodeToString(transactions))
    }

}