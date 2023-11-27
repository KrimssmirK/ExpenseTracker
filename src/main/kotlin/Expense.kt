class Expense(
    var date: String,
    var amount: Int,
    var description: String,
    var category: String
) {
    fun getExpense() {
        println("$amount for $category")
    }
}