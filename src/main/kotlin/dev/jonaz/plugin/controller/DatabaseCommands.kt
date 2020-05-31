@file:Suppress("unused", "UNUSED_PARAMETER")

package dev.jonaz.plugin.controller

import dev.jonaz.plugin.component.user.NewUser
import dev.jonaz.plugin.util.command.CommandMapping
import hazae41.minecraft.kutils.bukkit.msg
import org.bukkit.command.Command
import org.bukkit.command.CommandSender

/**
 * The class name is an example
 * You can name it whatever you want
 */
class DatabaseCommands {

    @CommandMapping("db")
    fun testCommand(sender: CommandSender, cmd: Command, label: String, args: Array<String>) {
        val newUser = NewUser(sender.name)
        val insertId = newUser.insertByName()
        sender.msg("Your insert id is $insertId")
    }
}
