enum class IncomeCategory(
    val transactionsCategoryType: TransactionsCategoryType = TransactionsCategoryType.INCOME
) {
    SALARY,
    FREELANCE,
    RENT,
    GIFT,
    BUSINESS,
    OTHER,
}