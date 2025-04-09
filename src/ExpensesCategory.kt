enum class ExpensesCategory (
    val transactionsCategoryType: TransactionsCategoryType = TransactionsCategoryType.EXPENSES
){
    SHOPPING,
    TRAVEL,
    FOOD,
    RENT,
    GIFTS,
    BILLS,
    TRANSPORTATION,
    ENTERTAINMENT,
    PERSONAL_NEEDS,
    OTHER,
}