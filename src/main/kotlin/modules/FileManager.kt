package com.turashift.kotlincmd.modules

//Importing commands\Импорт команд
import com.turashift.kotlincmd.PROMT

//For working with files\Для работы с файлами
import java.io.File

fun createFile() {

    //Prompt manager\Промт менеджера
    print("$PROMT/Create File ~> ")

    //Requesting the file name and path\Запрос на имя файла или путь
    val file = File(readln())

    //Processing\Обработка
    try {

        if (file.createNewFile()) {

            println("File created: $file")

        } else {

            println("Failed to create the file: $file")

        }

    } catch (error: Exception) { //To prevent the program from crashing\Чтобы программа не упала

        println("Error: $error")

    }

}

fun deleteFile() {

    //Prompt manager\Промт менеджера
    print("$PROMT/Delete File ~> ")

    //Requesting the file name and path\Запрос на имя файла или путь
    val file = File(readln())

    //Existence check\Проверка на существование
    if (file.exists()) {

        //Processing\Обработка
        try {

            if (file.delete()) {

                println("File deleted: $file")

            } else {

                println("Failed to delete the file: $file")

            }

        } catch (error: Exception) { //To prevent the program from crashing\Чтобы программа не упала

            println("Error: $error")

        }

    } else {

        println("The file does not exist or the directory is incorrect: $file")

    }

}

const val CREATE_FILE_COMMAND = "cfile"
const val DELETE_FILE_COMMAND = "dfile"
