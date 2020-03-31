@file:Suppress("unused", "UNUSED_PARAMETER")

package dev.jonaz.controller

import dev.jonaz.component.user.NewUser
import dev.jonaz.util.command.CommandMapping
import hazae41.minecraft.kutils.bukkit.msg
import org.bukkit.command.Command
import org.bukkit.command.CommandSender

// Example name
class DatabaseCommands {

    @CommandMapping("test")
    fun testCommand(sender: CommandSender, cmd: Command, label: String, args: Array<String>) {
        val newUser = NewUser(sender.name)
        val insertId = newUser.insertByName()
        sender.msg("Your insert id is $insertId")
    }
}
