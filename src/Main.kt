import database.TransactionsInJsonSerialization
import database.TransactionsInMemory
import ui.UserActionsMenu

fun main() {
    val memory = TransactionsInJsonSerialization()
    val app = UserActionsMenu(memory)
    app.run()
}


