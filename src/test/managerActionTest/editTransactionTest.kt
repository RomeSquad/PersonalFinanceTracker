package test.managerActionTest

import entity.Categories

fun editTransactionTestCases() {
    //region Valid Cases for Each Field
    test.check(
        name = "when enter a valid and in range number return true",
        expectedResult = Validator.isValidTransactionType("1"),
        correctResult = true
    )
    test.check(
        name = "when enter an empty string return false",
        expectedResult = Validator.isValidTransactionType(""),
        correctResult = false
    )
    test.check(
        name = "when enter a negative number return false",
        expectedResult = Validator.isValidTransactionType("-1"),
        correctResult = false
    )
    test.check(
        name = "when enter an out of range number return false",
        expectedResult = Validator.isValidTransactionType("9"),
        correctResult = false
    )
    test.check(
        name = "when enter a character return false",
        expectedResult = Validator.isValidTransactionType("a"),
        correctResult = false
    )
    //endregion

    //region Invalid Cases for amount Field
    test.check(
        name = "when enter a decimal positive number return true",
        expectedResult = Validator.isValidAmount("1400.5"),
        correctResult = true
    )
    test.check(
        name = "when enter a negative number return false",
        expectedResult = Validator.isValidAmount("-1500"),
        correctResult = false
    )
    test.check(
        name = "when enter a character return false",
        expectedResult = Validator.isValidAmount("a"),
        correctResult = false
    )
    test.check(
        name = "when enter an empty string return false",
        expectedResult = Validator.isValidAmount(""),
        correctResult = false
    )
    //endregion

    //region Invalid Cases for category Field
    test.check(
        name = "when enter an input with just characters return true",
        expectedResult = Validator.isValidCategory(Categories.FOOD.name),
        correctResult = true
    )
    test.check(
        name = "when enter just numbers return false",
        expectedResult = Validator.isValidCategory("45201"),
        correctResult = false
    )
    test.check(
        name = "when enter an empty string return false",
        expectedResult = Validator.isValidCategory(""),
        correctResult = false
    )
    //endregion

}
