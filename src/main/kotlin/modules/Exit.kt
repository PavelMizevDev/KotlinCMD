package com.turashift.kotlincmd.modules

fun exit(): Boolean {

    //KeyVariable
    var output: Boolean

    print("Confirm exit? [Y/n] ")

    val confirm = readln()

    //CommandProcessing
    when (confirm) {

        "Y", "y" -> {

            output = false

        }
        "N", "n" -> {

            print("Exit cancelled!")
            output = true

        }
        else -> {

            print("Exit cancelled due to user input error.")
            output = true

        }

    }

    return output

}

const val EXIT_COMMAND = "exit"
