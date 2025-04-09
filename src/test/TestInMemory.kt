package test

import Transaction
import java.time.LocalDate

fun main() {
    checkDeleteTransction()
}

fun checkDeleteTransction() {
    var myTransaction = mutableListOf(
        Transaction(amount = 100.0, category = "Travel", date = LocalDate(2030, 12, 20))
    )

    val user1 = User(
        mutableListOf(
            Transaction(amount = 100.0, category = "Travel", LocalDate(2000, 11, 20)),
            Transaction(amount = 100.0, category = "Travel", date = LocalDate(2030, 12, 20))
        )
    )

//    check(case="transaction not DELETED ",reterned_Result=user1.transactions,correctResult=myTransaction)
    user1.deleteTransaction(Transaction(amount = 100.0, category = "Travel", LocalDate(2000, 11, 20)))
    check(case = "transaction DELETED ", reterned_Result = user1.transactions, correctResult = myTransaction)

}


fun check(case: String, reterned_Result: MutableList<Transaction>, correctResult: MutableList<Transaction>) {
    if (reterned_Result == correctResult) {
        println("success_ ")
    } else {
        println("failed_ ")
    }
}

class User(val transactions: MutableList<Transaction>) {

    fun deleteTransaction(transaction: Transaction) {

        transactions.remove(transaction)
    }
}