package com.turashift.kotlincmd.modules

import kotlin.io.path.Path
import kotlin.io.path.exists
import kotlin.io.path.isDirectory

//StartFunction
fun fileManagerFun () {

    val fileManagerClass = FileManager()

    while (true) {

        print("You are on the following path: ")
        fileManagerClass.printFolder()
        print("Enter the command for FileManager: ")
        val command = readln()

        when (command) {

            HELP_COMMAND_IN_FILEMANAGER -> {

                println("""
                $HELP_COMMAND_IN_FILEMANAGER - Used to help with FileManager commands.
                $UP_FOLDER - After using this command you will be taken to the directory above.
                $GO_TO_FOLDER - After using this command you will be asked to enter the path to the directory you want to go to.
                $EXIT_FILEMANAGER - To exit FileManager.
                """.trimIndent())

            }

            UP_FOLDER -> fileManagerClass.upFolder()

            GO_TO_FOLDER -> {

                print("Which path should I take? ")
                fileManagerClass.goAlongThePath(readln())

            }

            EXIT_FILEMANAGER -> break

            else -> println("Unknown command: $command")

        }

    }

}

class FileManager {

    var currentFolder = Path(".").toAbsolutePath().normalize()

    fun printFolder () {

        println(currentFolder)

    }

    /* An important function that takes you to the directory above, that is, if you are in: '/home/user/Documents',
    then when you use the 'uF' command you will be redirected to '/home/user' */
    fun upFolder () {

        val upFolder = currentFolder.parent

        //Checking that we are not at the root
        if (upFolder != null) {

            currentFolder = upFolder

        } else {

            println("You are already at the root of the system!")

        }

    }

    /* An important function for directory navigation,
    let's say we are in '/home/user' after using the 'go' command we enter 'Videos' then we will end up in '/home/user/Videos',
    but if we enter with the first character '/' then we will completely change the path,
    for example, we were in '/home/user/Videos' and after using 'go' and typing for example: '/opt/JetBrains' , then we will end up in '/opt/JetBrains'.
    Conclusion: without '/' we will add the path,
    and with '/' (Or something else, depending on the OS in which the root of the directory is called differently) the path will be completely rewritten. */
    fun goAlongThePath (input: String) {

        val newFolder = currentFolder.resolve(input)

        //Processing for existence
        if (!newFolder.exists()) {

            println("Path doesn't exist!")

        } else if (!newFolder.isDirectory()) {

            println("Directory doesn't exist!")

        } else {

            currentFolder = newFolder

        }

    }

}

const val HELP_COMMAND_IN_FILEMANAGER = "help"
const val UP_FOLDER = "uF"
const val GO_TO_FOLDER = "go"
const val EXIT_FILEMANAGER = "exit"

const val FILE_MANAGER = "fM"
