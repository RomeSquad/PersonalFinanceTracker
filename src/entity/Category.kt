package entity

sealed class Category (
    val categoryName: String
){
    data class  Income(val incomeCategory: IncomeCategories):Category(incomeCategory.categoryName)
    data class  Expenses(val expensesCategory: ExpensesCategories):Category(expensesCategory.categoryName)
}