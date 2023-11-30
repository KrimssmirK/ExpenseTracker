fun main(args: Array<String>) {
    val menu = Menu()
    val menuList = arrayOf("ADD EXPENSES", "ADD INCOME", "ADD BALANCE", "EXIT")
    val menuView = MenuView()
    val menuController = MenuController(menu, menuView)
    menuController.updateMenu(menuList)
    menuController.updateView()
}