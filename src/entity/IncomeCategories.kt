package entity

enum class IncomeCategories(
     val categoryName: String
) {
    SALARY(categoryName = "salary"),
    FREELANCE(categoryName = "freelance"),
    BUSINESS(categoryName = "business"),
    OTHER(categoryName = "other"),
}