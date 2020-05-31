@file:Suppress("unused", "UNUSED_PARAMETER")

package dev.jonaz.plugin.controller

import dev.jonaz.plugin.util.command.CommandMapping
import hazae41.minecraft.kutils.bukkit.msg
import org.bukkit.command.Command
import org.bukkit.command.CommandSender

/**
 * The class name is an example
 * You can name it whatever you want
 */
class NormalCommands {

    @CommandMapping("abc")
    fun abcCommand(sender: CommandSender, cmd: Command, label: String, args: Array<String>) {
        sender.msg("yep thats a non-subcommand command")
        args.forEach { s: String ->
            println(s)
        }
    }

    @CommandMapping("abc", "test")
    fun abcTestCommand(sender: CommandSender, cmd: Command, label: String, args: Array<String>) {
        sender.msg("Abc test sub-command works :p")
        Thread.sleep(2000L)
        sender.msg("Look! Its not blocking the server")
    }

    @CommandMapping("abc", "yes", permission = "plugin.test")
    fun abcYesCommand(sender: CommandSender, cmd: Command, label: String, args: Array<String>) {
        sender.msg("the second sub-command")
    }
}
