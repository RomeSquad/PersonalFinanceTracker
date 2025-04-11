package entity

sealed class Category {
    data class  Income(val incomeCategory: IncomeCategories):Category()
    data class  Expenses(val expensesCategory: ExpensesCategories):Category()
}