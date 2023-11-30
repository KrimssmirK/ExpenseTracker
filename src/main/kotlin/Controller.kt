class MenuController(
    val menu: Menu,
    val menuView: MenuView
) {
    // Properties
    // 1. Menu (model)
    // 2. MenuView (view)

    // Functions
    // 1. updateView
    // 2. updateMenu

    fun updateView() : Unit {
        menuView.print(menu)
    }

    fun updateMenu(menuList: Array<String>) : Unit {
        for (item in menuList) {
            menu.addMenu(item)
        }
    }
}