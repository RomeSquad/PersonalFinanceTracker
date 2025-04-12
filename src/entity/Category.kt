package entity

import kotlinx.serialization.Serializable

@Serializable
sealed class Category {
    @Serializable
    data class  Income(val incomeCategory: IncomeCategories):Category()
    @Serializable
    data class  Expenses(val expensesCategory: ExpensesCategories):Category()
}