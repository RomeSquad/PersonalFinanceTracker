import database.TransactionsInJsonSerialization
import database.TransactionsInMemory
import ui.UserActionsMenu

fun main() {
    val memory = TransactionsInMemory()
    //val json = TransactionsInJsonSerialization()
    //val dataBases = TransactionsInDataBases()
    val app = UserActionsMenu(memory)
    app.run()
}


