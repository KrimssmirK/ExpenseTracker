import java.time.LocalDate

fun showMenu(currBalance: Balance) {
    val date = LocalDate.now()
    println("--------------")
    println("${date.month} Budget")
    println("--------------")
    println("Balance: P${currBalance.amount}")
    println("[1]Add Expenses")
    println("[2]Add Income")
    println("[3]Add Balance")
    println("[4]Exit")
    print("Enter: ")
}

fun addBalance(currBalance: Balance) {
    var numeric = false
    var balance: Int? = 0
    while (!numeric) {
        println("ADD BALANCE")
        print("amount: ")
        val balanceString = readLine()
        try {
            balance = balanceString?.toInt()
            numeric = true
        } catch (e: NumberFormatException) {
            println("invalid format")
        }
    }
    currBalance.amount = balance
}

fun selectMenu(currBalance: Balance) : Boolean {
    var exit: Boolean = false
    while (true) {
        showMenu(currBalance)
        var enter = readLine()
        if (enter == "1") {
            println("enter 1")
            break
        } else if (enter == "2"){
            println("enter 2")
            break
        } else if (enter == "3") {
            addBalance(currBalance)
            break
        } else if (enter == "4") {
            exit = true
            break
        } else {
            println("please enter 1 or 2")
        }
    }
    return exit
}


fun startApp() {
    val myBalanceDB = SQLiteDatabase()
    val currBalance = myBalanceDB.retrieve()
    var exit = false
    while (!exit) {
        exit = selectMenu(currBalance)
    }
    currBalance.amount?.let { myBalanceDB.update(it) }
    println("Bye!")
}

fun main(args: Array<String>) {
    startApp()
}