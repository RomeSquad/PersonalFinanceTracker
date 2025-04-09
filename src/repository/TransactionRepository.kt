package repository



//TODO : Add your transaction fun here and impl it
interface TransactionRepository {
    fun fetchCurrentBalance ():Double
    fun fetchTotalIncome():Double
    fun fetchTotalExpense():Double
}