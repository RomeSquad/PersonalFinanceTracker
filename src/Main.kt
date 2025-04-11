import database.TransactionsInMemory
import ui.UserActionsMenu

fun main() {
    val memory = TransactionsInMemory()
    val app = UserActionsMenu(memory)
    app.run()
}


