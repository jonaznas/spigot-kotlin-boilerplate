package plugin

import hazae41.minecraft.kutils.bukkit.schedule
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import plugin.services.Instance
import plugin.commands.Abc

class Commands {

    init {
        // Just duplicate the line to add a new command
        register("abc", Abc::invoke) // "abc" is the command name and "Abc::invoke" is the invoke operator in src/commands/Abc
    }

    private fun register(name: String, f: (sender: CommandSender?, command: Command?, label: String?, args: Array<String>?) -> Unit) {
        Instance.plugin.getCommand(name).executor = CommandExecutor { sender, command, label, args ->
            Instance.plugin.schedule(async = true) { f(sender, command, label, args) }
            true
        }
    }
}
