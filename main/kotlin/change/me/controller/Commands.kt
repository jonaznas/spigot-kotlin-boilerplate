@file:Suppress("unused")

package change.me.controller

import change.me.util.command.CommandMapping
import hazae41.minecraft.kutils.bukkit.msg
import org.bukkit.command.Command
import org.bukkit.command.CommandSender

class Commands {

    @CommandMapping("abc")
    fun abcCommand(sender: CommandSender, cmd: Command, label: String, args: Array<String>) {
        sender.msg("Abc command works! :p")
    }
}
