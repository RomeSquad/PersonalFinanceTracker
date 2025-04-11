package entity

enum class IncomeCategories(
    override val categoryName: String
) : ICategory{
    SALARY(categoryName = "salary"),
    FREELANCE(categoryName = "freelance"),
    BUSINESS(categoryName = "business"),
    OTHER(categoryName = "other"),
}