package com.turashift.kotlincmd

//Importing commands
import com.turashift.kotlincmd.modules.EXIT_COMMAND

//Importing functions from modules
import com.turashift.kotlincmd.modules.exit

fun main() {

    //Variables
    var exit_Output = false

    //Main program loop
    while (exit_Output == false) {

        //Command promt
        println()
        print("kcmd ~# ")

        //Read command
        var command = readln()

        //Action after input
        when(command) {
            HELP_COMMAND -> {
                println("help - displays available commands")
                print("$EXIT_COMMAND - closes the terminal after confirmation")
            }

            EXIT_COMMAND -> exit_Output = exit()
        }

    }

}

const val HELP_COMMAND = "help"


/*
Hi!
I wrote this pseudo-terminal while learning Kotlin.
There might be some bugs, but I think it turned out pretty well!
I created it to implement a concept that allows users to load their own plugin files (in .jar format).
I plan to keep developing this project! Programmer and author: Pavel Mizev.

Please don't hold any potentially incorrect English against me;
I’m a Russian programmer and don't speak the language, so I used Google Translate for all the English text.
 */
