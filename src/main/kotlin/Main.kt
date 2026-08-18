package com.turashift.kotlincmd

//ImportCommands
import com.turashift.kotlincmd.modules.EXIT_COMMAND
import com.turashift.kotlincmd.modules.CALC_COMMAND
//import com.turashift.kotlincmd.modules.CREATE_FILE_COMMAND
//import com.turashift.kotlincmd.modules.DELETE_FILE_COMMAND
import com.turashift.kotlincmd.modules.INFO_CMD_COMMAND
import com.turashift.kotlincmd.modules.TIMER_MANAGER_COMMAND

//Importing functions, classes from modules
import com.turashift.kotlincmd.modules.exit
import com.turashift.kotlincmd.modules.calc
//import com.turashift.kotlincmd.modules.CreateFile
//import com.turashift.kotlincmd.modules.DeleteFile
import com.turashift.kotlincmd.modules.infoCMD
import com.turashift.kotlincmd.modules.timeManagerFun

fun main() {



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
                    $HELP_COMMAND - displays available commands.
                    $EXIT_COMMAND - closes the terminal after confirmation.
                    $CALC_COMMAND - launches the calculator.
                    $INFO_CMD_COMMAND - displaying project information.
                    $TIMER_MANAGER_COMMAND - starting the TimerManager (Timer/Stopwatch).
                    """.trimIndent()
                )

            }
            EXIT_COMMAND -> exitOutput = exit()
            CALC_COMMAND -> calc()
            //CREATE_FILE_COMMAND -> CreateFile()
            //DELETE_FILE_COMMAND -> DeleteFile()
            INFO_CMD_COMMAND -> infoCMD()
            TIMER_MANAGER_COMMAND -> timeManagerFun()
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
