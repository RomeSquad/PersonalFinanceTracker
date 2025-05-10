import database.TransactionsInJsonSerialization
import database.TransactionsInMemory
import database.TransactionsManager
import ui.UserActionsMenu

fun main() {
    val memory: TransactionsManager
    println("Do you want to save on desk? type y/n")
    val input = readln().trim()
    when (input) {
        "y" -> {
            memory = TransactionsInJsonSerialization()
        }

        "n" -> {
            memory = TransactionsInMemory()
        }
        else -> {
            println("we couldn't recognize your input")
            return
        }
    }

    val app = UserActionsMenu(memory)
    app.run()
}


