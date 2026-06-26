package com.turashift.kotlincmd.modules

fun exit(): Boolean {

    //Exit val
    var output: Boolean

    //Confirmation request
    print("Confirm exit? [Y/n] ")

    //User confirmation
    val confirm = readln()

    //Action after input
    when (confirm) {
        "Y", "y" -> {
            output = true
        }
        "N", "n" -> {
            print("Exit cancelled")
            output = false
        }
        else -> {
            print("Exit cancelled due to user input error.")
            output = false
        }

    }
    //Data
    return output
}

const val EXIT_COMMAND = "exit"
