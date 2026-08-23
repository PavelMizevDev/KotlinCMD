package com.turashift.kotlincmd.modules

fun infoCMD () {

    println(
        """
        Project: KotlinCMD
        Version: 14-23082026a
        Last updated: 23.08.2026 (DD.MM.YYYY)
        Status: alpha
        Author: Pavel Mizev
        Developers:
        - Pavel Mizev ( https://github.com/PavelMizevDev )
        - Roit ( https://github.com/Roit-liasp )
        """.trimIndent()
    )

}

const val INFO_CMD_COMMAND = "info_cmd"
