package entity

enum class Categories (
    val transactionsType: TransactionsType ,
    val categoryName : String

){
    SHOPPING( transactionsType = TransactionsType.EXPENSES ,categoryName = "shopping"),
    TRAVEL(transactionsType = TransactionsType.EXPENSES ,categoryName = "travel"),
    FOOD(transactionsType = TransactionsType.EXPENSES ,categoryName = "food"),
    RENT(transactionsType = TransactionsType.EXPENSES ,categoryName = "rent"),
    GIFTS(transactionsType = TransactionsType.EXPENSES ,categoryName = "gifts"),
    BILLS(transactionsType = TransactionsType.EXPENSES ,categoryName = "bills"),
    TRANSPORTATION(transactionsType = TransactionsType.EXPENSES ,categoryName = "transportation"),
    ENTERTAINMENT(transactionsType = TransactionsType.EXPENSES ,categoryName = "entertainment"),
    PERSONAL_NEEDS(transactionsType = TransactionsType.EXPENSES ,categoryName = "personal needs"),


    SALARY(transactionsType = TransactionsType.INCOME ,categoryName = "salary"),
    FREELANCE(transactionsType = TransactionsType.INCOME ,categoryName = "freelance"),
    BUSINESS(transactionsType = TransactionsType.INCOME ,categoryName = "business"),

}
