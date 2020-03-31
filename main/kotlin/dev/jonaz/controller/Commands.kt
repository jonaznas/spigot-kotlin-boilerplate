@file:Suppress("unused", "UNUSED_PARAMETER")

package dev.jonaz.controller

import change.me.component.user.NewUser
import dev.jonaz.util.command.CommandMapping
import hazae41.minecraft.kutils.bukkit.msg
import org.bukkit.command.Command
import org.bukkit.command.CommandSender

class Commands {

    @CommandMapping("abc")
    fun abcCommand(sender: CommandSender, cmd: Command, label: String, args: Array<String>) {
        sender.msg("Abc command works :p")
        Thread.sleep(2000L)
        sender.msg("Look! Its not blocking the server")
    }

    @CommandMapping("test")
    fun dbTestCommand(sender: CommandSender, cmd: Command, label: String, args: Array<String>) {
        val newUser = NewUser(sender.name)
        val insertId = newUser.insertByName()
        sender.msg("Your insert id is $insertId")
    }
}
