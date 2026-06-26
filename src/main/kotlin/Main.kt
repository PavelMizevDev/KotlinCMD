package com.turashift.kotlincmd

//Importing commands\Импорт команд
import com.turashift.kotlincmd.modules.EXIT_COMMAND
import com.turashift.kotlincmd.modules.CALC_COMMAND
import com.turashift.kotlincmd.modules.CREATE_FILE_COMMAND
import com.turashift.kotlincmd.modules.DELETE_FILE_COMMAND

//Importing functions from modules\Импорт функций модулей
import com.turashift.kotlincmd.modules.exit
import com.turashift.kotlincmd.modules.calc
import com.turashift.kotlincmd.modules.createFile
import com.turashift.kotlincmd.modules.deleteFile

fun main() {

    //Variables\Переменные
    var exit_Output = false

    //Main program loop\Основной цикл
    while (exit_Output == false) {

        //Command promt\Промт команды
        print("kcmd ~> ")

        //Read command\Ввод команды
        var command = readln()

        //Command processing\Обработка команды
        when(command) {

            HELP_COMMAND -> {
                println("$HELP_COMMAND - displays available commands.")
                println("$EXIT_COMMAND - closes the terminal after confirmation.")
                println("$CALC_COMMAND - launches the calculator.")
                println("$CREATE_FILE_COMMAND - file creation command.")
                println("$DELETE_FILE_COMMAND - file deletion command.")
            }

            EXIT_COMMAND -> exit_Output = exit()

            CALC_COMMAND -> calc()

            CREATE_FILE_COMMAND -> createFile()

            DELETE_FILE_COMMAND -> deleteFile()

            else -> println("Unknown command: $command.")

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
