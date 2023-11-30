class Menu {
    // Properties
    // 1. menu list

    // Functions
    // 1. addMenu

    val menuList: MutableList<String> = mutableListOf()

    fun addMenu(menu: String) : Unit {
        menuList.add(menu)
    }

}


data class Balance(var amount: Int?)