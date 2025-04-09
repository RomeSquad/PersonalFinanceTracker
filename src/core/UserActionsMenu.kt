package core

fun userActionsMenu() {

    println("************* ")
    println("Welcome to your Finance Tracker App ")
    println("************* ")

    print("Please enter your name :  ")
    val name: String = readln()
    println("Welcome $name ")

    println("************* ")
    println("you have many options to choice")
    println("************* ")

    println("if you want to add money ->  press letter ( a ) ")
    println("if you want to edit  -> press letter ( e )")
    println("if you want to view  -> press letter ( v )  ")
    println("if you want to delete  ->  press letter ( d ) ")
    println("if you want to show your monthly summary report ->  press letter ( m ) ")
    println("if you want to show your balance report ->  press letter ( r )  ")
    println("if you want to exit the app ->  press letter ( q ) ")

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

    }
}