package com.turashift.kotlincmd.modules

import com.turashift.kotlincmd.HELP_COMMAND

import kotlin.io.path.Path
import kotlin.io.path.createDirectory
import kotlin.io.path.createFile
import kotlin.io.path.deleteExisting
import kotlin.io.path.exists
import kotlin.io.path.isDirectory
import kotlin.io.path.listDirectoryEntries

//StartFunction
fun fileManagerFun () {

    val fileManagerClass = FileManager()

    while (true) {

        print("You are on the following path: ")
        fileManagerClass.printFolder()
        print("Enter the command for FileManager: ")
        val command = readln()

        when (command) {

            HELP_COMMAND -> {

                println("""
                $HELP_COMMAND - Used to help with FileManager commands.
                $UP_FOLDER - After using this command you will be taken to the directory above.
                $GO_TO_FOLDER - After using this command you will be asked to enter the path to the directory you want to go to.
                $LIST_FOLDER - Displays a list of files or folders in the selected folder path.
                $CREATE_DIR - Use to create a folder.
                $CREATE_FILE - Use to create a file.
                $REMOVE_DIR_OR_FILE - Use to remove a folder or file.
                $EXIT_COMMAND - To exit FileManager.
                """.trimIndent())

            }

            UP_FOLDER -> fileManagerClass.upFolder()

            GO_TO_FOLDER -> {

                print("Which path should I take? ")
                fileManagerClass.goAlongThePath(readln())

            }

            LIST_FOLDER -> fileManagerClass.listFolder()

            CREATE_DIR -> fileManagerClass.createDirectory()

            CREATE_FILE -> fileManagerClass.createFile()

            REMOVE_DIR_OR_FILE -> fileManagerClass.removeFileOrDir()

            EXIT_COMMAND -> break

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

            println("This path is a file, not a directory!")

        } else {

            currentFolder = newFolder

        }

    }

    /* A very important function for displaying files and folders as a list;
    that is, if you are in '/home/user/Videos', using the 'list' command will output a list of folders and files, for example:
    [Directory] Family
    [File] film.mov
    */
    fun listFolder  () {

        if (!currentFolder.exists()) {

            println("Path doesn't exist!")
            return

        }

        val listVal = currentFolder.listDirectoryEntries()

        try {

            if (listVal.isEmpty()) {

                println("The folder is empty.")
                return

            }

            for (item in listVal) {

                if (item.isDirectory()) {

                    println("[Directory] ${item.fileName}")

                } else {

                    println("[File] ${item.fileName}")

                }

            }

        } catch (e: Exception) {

            println("Error: ${e.message}")

        }

    }

    /* An important function for creating files—for example,
    when located in 'home/user/'—is that after using the 'cD' command and entering a name (such as 'Games'),
    a folder with the path 'home/user/Games' will be created.
    (It is best not to start the name with a '/' character; otherwise, the folder will be created at the root of the disk.) */
    fun createDirectory () {

        if (!currentFolder.exists()) {

            println("Path doesn't exist!")
            return

        }

        print("Name the folder: ")
        val nameFolder = currentFolder.resolve(readln())

        if (nameFolder.exists()) {

            println("Directory already exists!")
            return

        }

        try {

            nameFolder.createDirectory()
            println("Folder $nameFolder successfully created!")

        } catch (e: Exception) {

            println("Error: ${e.message}")

        }

    }

    /* A useful function for creating empty files: for example,
    if you are in '/home/user/Documents' and use the 'cF' command followed by a filename with an extension (such as 'file.txt'),
    a file with the path '/home/user/Documents/file.txt' will be created.
    (It is best not to start the name with a '/' character; otherwise, the folder will be created at the root of thek.) */
    fun createFile () {

        if (!currentFolder.exists()) {

            println("Path doesn't exist!")
            return

        }

        print("Name the file: ")
        val nameFile = currentFolder.resolve(readln())

        if (nameFile.exists()) {

            println("The file already exists!")
            return

        }

        try {

            nameFile.createFile()
            println("File $nameFile successfully created!")

        } catch (e: Exception) {

            println("Error: ${e.message}")

        }

    }

    /* This is an important function for deleting files or folders; for example,
    if you are in 'home/user/NNdir', using the 'del' command followed by the name of the folder or file will delete it.
    Important: if you are deleting a folder, it must be empty! */
    fun removeFileOrDir () {

        if (!currentFolder.exists()) {

            println("Path doesn't exist!")
            return

        }

        print("Name of the folder or file to delete: ")
        val inputName = currentFolder.resolve(readln())

        if (!inputName.exists()) {

            println("The file already exists!")
            return

        }

        try {

            inputName.deleteExisting()
            println("File $inputName successfully deleted!")

        } catch (e: Exception) {

            println("Error: ${e.message}")

        }

    }

}

const val UP_FOLDER = "uf"
const val GO_TO_FOLDER = "cd"
const val LIST_FOLDER = "list"
const val CREATE_DIR = "cdir"
const val CREATE_FILE = "cfil"
const val REMOVE_DIR_OR_FILE = "del"

const val FILE_MANAGER = "fmanag"
