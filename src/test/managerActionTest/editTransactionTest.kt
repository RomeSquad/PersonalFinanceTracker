package test.managerActionTest

import Transaction
import TransactionType
import java.time.LocalDate

fun editTransactionTestCases() {
    val transactionMangerActionsTest = TransactionMangerActionsTest()

    //region Valid Cases for Each Field
    test.check(
        name = "when all attributes are valid should return true",
        expectedResult = transactionMangerActionsTest.editTransaction(
            Transaction(
                date = LocalDate.now(),
                amount = 100.0,
                category = "Valid",
                type = TransactionType.EXPENSE
            )
        ),
        correctResult = true
    )
    test.check(
        name = "when amount is valid should return true",
        expectedResult = transactionMangerActionsTest.editTransaction(
            Transaction(
                date = LocalDate.now(),
                amount = 100.0,
                category = "Valid",
                type = TransactionType.EXPENSE
            )
        ),
        correctResult = true
    )
    test.check(
        name = "when category is valid should return true",
        expectedResult = transactionMangerActionsTest.editTransaction(
            Transaction(
                date = LocalDate.now(),
                amount = 100.0,
                category = "Valid",
                type = TransactionType.EXPENSE
            )
        ),
        correctResult = true
    )
    test.check(
        name = "when date is valid should return true",
        expectedResult = transactionMangerActionsTest.editTransaction(
            Transaction(
                date = LocalDate.now(),
                amount = 100.0,
                category = "Valid",
                type = TransactionType.EXPENSE
            )
        ),
        correctResult = true
    )
    //endregion

    //region Invalid Cases for amount Field
    test.check(
        name = "when amount is invalid should return false",
        expectedResult = transactionMangerActionsTest.editTransaction(
            Transaction(
                date = LocalDate.now(),
                amount = -100.0,
                category = "Valid",
                type = TransactionType.EXPENSE
            )
        ),
        correctResult = false
    )
    test.check(
        name = "when editing transaction with zero amount should return false",
        expectedResult = transactionMangerActionsTest.editTransaction(
            Transaction(
                date = LocalDate.now(),
                amount = 0.0,
                category = "Food",
                type = TransactionType.EXPENSE
            )
        ),
        correctResult = false
    )
    //endregion

    //region Invalid Cases for category Field
    test.check(
        name = "when editing transaction with empty category should return false",
        expectedResult = transactionMangerActionsTest.editTransaction(
            Transaction(
                date = LocalDate.now(),
                amount = 150.0,
                category = "",
                type = TransactionType.EXPENSE
            )
        ),
        correctResult = false
    )
    test.check(
        name = "when category be maximum length should return false",
        expectedResult = transactionMangerActionsTest.editTransaction(
            Transaction(
                date = LocalDate.now(),
                amount = 100.0,
                category = "A".repeat(51), // Assuming 50 is max length
                type = TransactionType.EXPENSE
            )
        ),
        correctResult = false
    )
    test.check(
        name = "when category contains special characters should return false",
        expectedResult = transactionMangerActionsTest.editTransaction(
            Transaction(
                date = LocalDate.now(),
                amount = 100.0,
                category = "Food@123",
                type = TransactionType.EXPENSE
            )
        ),
        correctResult = false
    )
    test.check(
        name = "when category is blank should return false",
        expectedResult = transactionMangerActionsTest.editTransaction(
            Transaction(
                date = LocalDate.now(),
                amount = 100.0,
                category = "   ",
                type = TransactionType.EXPENSE
            )
        ),
        correctResult = false
    )
    test.check(
        name = "when category contains only numbers should return false",
        expectedResult = transactionMangerActionsTest.editTransaction(
            Transaction(
                date = LocalDate.now(),
                amount = 100.0,
                category = "1234567890",
                type = TransactionType.EXPENSE
            )
        ),
        correctResult = false
    )
    test.check(
        name = "when category contains leading and trailing spaces should return false",
        expectedResult = transactionMangerActionsTest.editTransaction(
            Transaction(
                date = LocalDate.now(),
                amount = 100.0,
                category = "   Food   ",
                type = TransactionType.EXPENSE
            )
        ),
        correctResult = false
    )
    //endregion

    //region Invalid Cases for type Field
    test.check(
        name = "when type is EXPENSE with negative amount should return false",
        expectedResult = transactionMangerActionsTest.editTransaction(
            Transaction(
                date = LocalDate.now(),
                amount = -100.0,
                category = "Valid",
                type = TransactionType.EXPENSE
            )
        ),
        correctResult = false
    )
    test.check(
        name = "when type is INCOME with negative amount should return false",
        expectedResult = transactionMangerActionsTest.editTransaction(
            Transaction(
                date = LocalDate.now(),
                amount = -100.0,
                category = "Valid",
                type = TransactionType.INCOME
            )
        ),
        correctResult = false
    )
    test.check(
        name = "when type is null should return false",
        expectedResult = transactionMangerActionsTest.editTransaction(
            Transaction(
                date = LocalDate.now(),
                amount = 100.0,
                category = "Valid",
                type = null
            )
        ),
        correctResult = false
    )
    //endregion

}
