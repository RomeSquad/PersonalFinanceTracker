package test

import entity.Transaction
import java.time.LocalDate
//fun main() {
//
//    val invalidTransaction = Transaction(
//        amount = -50.0,
//        category = "",
//        date = LocalDate.now().plusDays(2)
//    )
//
//    val transaction = Transaction(
//        amount = 100.0,
//        category = "Salary",
//        date = LocalDate.now()
//    )
//
//    check(
//        name = "Amount should be greater than 0",
//        result = transaction.validAmount(),
//        correctResult = true
//    )
//    check(
//        name = "date  should be in the present",
//        result = transaction.validDate(),
//        correctResult = true
//    )
//
//    check(
//        name = "ID should be unique and non-null",
//        result = transaction.id.toString().isNotBlank(),
//        correctResult = true
//    )
//
//    check(
//        name = "Invalid: negative amount should fail",
//        result = invalidTransaction.amount > 0,
//        correctResult = false
//    )
//
//    check(
//        name = "Invalid: empty category should fail",
//        result = invalidTransaction.category.isNotBlank(),
//        correctResult = false
//    )
//
//    check(
//        name = "Invalid: future date should fail",
//        result = !invalidTransaction.date.isAfter(LocalDate.now()),
//        correctResult = false
//    )
//}
//
//fun check(name: String, result: Boolean, correctResult: Boolean) {
//    if (result == correctResult) {
//        println(" success - $name")
//    } else {
//        println(" failed  - $name")
//    }
//}