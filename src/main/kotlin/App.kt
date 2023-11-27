fun main(args: Array<String>) {
    // do something
    var balance = 1000
    println("--------------")
    println("Monthly Budget")
    println("--------------")
    println("Balance: P$balance")
    println("[1]Add Expenses")
    println("[2]Add Income")
    print("Enter: ")
    var enter = readLine()
    if (enter != null) {
        when (enter.toInt()) {
            1 -> println("enter 1")
            2 -> println("enter 2")
            else -> println("INVALID SELECTION")
        }
    } else {
        println("INVALID")
    }

}