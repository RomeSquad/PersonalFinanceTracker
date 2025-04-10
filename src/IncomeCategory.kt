enum class IncomeCategory(
    val transactionsCategoryType: TransactionsCategoryType = TransactionsCategoryType.INCOME,
    val categoryName : String
) {
    SALARY(categoryName = "salary"),
    FREELANCE(categoryName = "freelance"),
    RENT(categoryName = "rent"),
    GIFT(categoryName = "gift"),
    BUSINESS(categoryName = "business"),
    OTHER(categoryName = "other"),
}