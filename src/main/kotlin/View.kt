import java.time.LocalDate
class MenuView(){
    fun print(menu: Menu) : Unit {
        for ((index, value) in menu.menuList.withIndex()) {
            println("[${index+1}]$value")
        }
    }

    // Properties
    // 1. title

    // Functions
}