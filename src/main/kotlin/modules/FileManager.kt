package com.turashift.kotlincmd.modules

//For working with files\Для работы с файлами
import java.io.File

fun createFile() {

    //Prompt manager\Промт менеджера
    print("Create File ~> ")

    //Requesting the file name and path\Запрос на имя файла или путь
    val file = File(readln())

    //Processing\Обработка
    if (file.createNewFile() == true) {

        println("File created: $file")

    } else {

        println("Failed to create the file: $file")

    }

}

fun deleteFile() {

    //Prompt manager\Промт менеджера
    print("Delete File ~> ")

    //Requesting the file name and path\Запрос на имя файла или путь
    val file = File(readln())

    //Existence check\Проверка на существование
    if (file.exists() == true) {

        //Processing\Обработка
        if (file.delete() == true) {

            println("File deleted: $file")

        } else {

            println("Failed to delete the file: $file")

        }

    } else {

        println("The file does not exist or the directory is incorrect: $file")

    }

}

const val CREATE_FILE_COMMAND = "cfile"
const val DELETE_FILE_COMMAND = "dfile"
