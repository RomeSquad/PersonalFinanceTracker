package core

fun userActionsMenu() {

    welcomeSection()
    optionSection()

}

private fun optionSection() {
    println("************* ")
    println("you have many options to choice")
    println("************* ")

    println("Add Transaction ->  press letter ( a ) ")
    println("Edit Transaction -> press letter ( e )")
    println("View Transaction -> press letter ( v )  ")
    println("Delete Transaction ->  press letter ( d ) ")
    println("Show your monthly summary report ->  press letter ( m ) ")
    println("Show your balance report ->  press letter ( r )  ")
    println("Exit the app ->  press letter ( q ) ")

    print("what do you want : ")
    val option: String = readln()


    when (option) {
        "a" -> {
            //TODO call add fun

        }

        "e" -> {
            //TODO call edit fun

        }

        "v" -> {
            //TODO call view fun

        }

        "d" -> {
            //TODO call delete fun

        }

        "m" -> {
            // TODO call monthly report fun

        }

        "r" -> {
            // TODO call balance report fun

        }

        "q" -> {
            // TODO call balance report fun
        }

        else -> {
            println("Invalid Option")
        }

    }
}

private fun welcomeSection() {
    println("************* ")
    println("Welcome to your Finance Tracker App ")
    println("************* ")

    print("Please enter your name :  ")
    val name: String = readln()
    println("************* ")
    println("Welcome $name ")
}