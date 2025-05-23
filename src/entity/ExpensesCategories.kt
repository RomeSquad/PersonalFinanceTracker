package entity

enum class ExpensesCategories(
     val categoryName: String
){
    SHOPPING(categoryName = "shopping"),
    TRAVEL(categoryName = "travel"),
    FOOD(categoryName = "food"),
    RENT(categoryName = "rent"),
    GIFTS(categoryName = "gifts"),
    BILLS(categoryName = "bills"),
    TRANSPORTATION(categoryName = "transportation"),
    ENTERTAINMENT(categoryName = "entertainment"),
    PERSONAL_NEEDS(categoryName = "personal needs"),
    OTHER(categoryName = "other")
}