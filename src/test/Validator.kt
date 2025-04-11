package test

import entity.TransactionsType

object Validator {

    fun isValidTransactionType(input: String): Boolean {
        val index = input.toIntOrNull() ?: -1
        return TransactionsType.entries.getOrNull(index - 1) != null
    }

    fun isValidCategory(input: String): Boolean {
        if (input.isEmpty() || input.isBlank()) return false
        if (input.all { it.isDigit() }) return false
        return true
    }

    fun isValidAmount(input: String): Boolean {
        val value = input.toDoubleOrNull() ?: return false
        if (value < 0) return false
        return true
    }



}