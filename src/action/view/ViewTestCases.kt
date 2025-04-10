package action.view

import Transaction

fun checkForEmptyList (
    transactions: List<Transaction>
) {
    if (transactions.isEmpty()) {
        println("No transactions found. \nTo add a new transaction, please go to the main menu and select 'Add'.")
    }
}

fun check (
    name: String,
    result: Boolean,
    correctResult: Boolean
) {
    if (result == correctResult) {
        println("success, $name")
    } else {
        println("failed $name")
    }
}