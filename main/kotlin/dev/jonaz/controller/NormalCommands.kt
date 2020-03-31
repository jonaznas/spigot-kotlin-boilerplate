@file:Suppress("unused", "UNUSED_PARAMETER")

package dev.jonaz.controller

import dev.jonaz.util.command.CommandMapping
import hazae41.minecraft.kutils.bukkit.msg
import org.bukkit.command.Command
import org.bukkit.command.CommandSender

// Example name
class NormalCommands {

    @CommandMapping("abc")
    fun abcCommand(sender: CommandSender, cmd: Command, label: String, args: Array<String>) {
        sender.msg("Abc command works :p")
        Thread.sleep(2000L)
        sender.msg("Look! Its not blocking the server")
    }
}
