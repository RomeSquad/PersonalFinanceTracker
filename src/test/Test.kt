package test

public fun <T> check(
    name: String,
    expectedResult: T,
    correctResult: T,
) {
    if (expectedResult == correctResult) {
        println("success - $name")
    } else {
        println("Fail - $name")
    }
}