package com.turashift.kotlincmd

//ImportCommands
import com.turashift.kotlincmd.modules.EXIT_COMMAND
import com.turashift.kotlincmd.modules.CALC_COMMAND
import com.turashift.kotlincmd.modules.INFO_CMD_COMMAND
import com.turashift.kotlincmd.modules.TIMER_MANAGER_COMMAND
import com.turashift.kotlincmd.modules.FILE_MANAGER

//Importing functions, classes from modules
import com.turashift.kotlincmd.modules.exit
import com.turashift.kotlincmd.modules.Calculator
import com.turashift.kotlincmd.modules.infoCMD
import com.turashift.kotlincmd.modules.timeManagerFun
import com.turashift.kotlincmd.modules.fileManagerFun

fun main() {

    val calcValue = Calculator()

    //KeyVariable
    var exitOutput = true

    //MainCycleProgram
    while (exitOutput) {

        //TerminalPrompt
        print("$PROMPT ~> ")

        val command = readln()

        //ProcessingCommands
        when(command) {

            HELP_COMMAND -> {

                println(
                    """
                    $HELP_COMMAND - Displays available commands.
                    $EXIT_COMMAND - Closes the terminal after confirmation.
                    $CALC_COMMAND - Launches the calculator.
                    $INFO_CMD_COMMAND - Displaying project information.
                    $TIMER_MANAGER_COMMAND - Запускает TimeManager (Timer/Stopwatch).
                    $FILE_MANAGER - Launches FileManager.
                    """.trimIndent()
                )

            }
            EXIT_COMMAND -> exitOutput = exit()
            CALC_COMMAND -> calcValue.calc()
            INFO_CMD_COMMAND -> infoCMD()
            TIMER_MANAGER_COMMAND -> timeManagerFun()
            FILE_MANAGER -> fileManagerFun()
            else -> println("Unknown command: $command.")

        }

    }

}

const val HELP_COMMAND = "help"
const val PROMPT = "kcmd"


/*
Hi!
I wrote this pseudo-terminal while learning Kotlin.
There might be some bugs, but I think it turned out pretty well!
I created it to implement a concept that allows users to load their own plugin files (in .jar format).
I plan to keep developing this project! Programmer and author: Pavel Mizev.

Please don't hold any potentially incorrect English against me;
I’m a Russian programmer and don't speak the language, so I used Google Translate for all the English text.
 */
