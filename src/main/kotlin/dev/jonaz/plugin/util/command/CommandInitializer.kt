package dev.jonaz.plugin.util.command

import dev.jonaz.plugin.util.plugin.Instance
import dev.jonaz.plugin.Main
import hazae41.minecraft.kutils.bukkit.command
import hazae41.minecraft.kutils.bukkit.msg
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.reflections.Reflections
import org.reflections.scanners.MethodAnnotationsScanner
import java.lang.reflect.Method

class CommandInitializer {
    private val plugin = Instance.plugin
    private val permissionMsg: String? = plugin.config.getString("errors.permission")

    fun defineCommands() {
        val commands: MutableMap<String, MutableMap<String, Pair<String, Method>>> = mutableMapOf()
        val reflections = Reflections(Main::class.java, MethodAnnotationsScanner())
        val annotated = reflections.getMethodsAnnotatedWith(CommandMapping::class.java)

        for (method in annotated) {
            val cmd = method.getAnnotation(CommandMapping::class.java).cmd
            val sub = method.getAnnotation(CommandMapping::class.java).sub
            val perm = method.getAnnotation(CommandMapping::class.java).permission

            when (commands[cmd]) {
                null -> commands[cmd] = mutableMapOf(sub to Pair(perm, method))
                else -> commands[cmd]?.set(sub, Pair(perm, method))
            }
        }

        commands.forEach { (t, u) ->
            Instance.plugin.getCommand(t).executor = CommandExecutor { sender, command, label, args ->
                val subCommand = when (args.size) {
                    in Int.MIN_VALUE..0 -> ""
                    else -> args[0]
                }

                val method = when (u.containsKey(subCommand)) {
                    true -> u[subCommand]
                    else -> u[""]
                } as Pair<String, Method>

                val instance = method.second.declaringClass?.getDeclaredConstructor()?.newInstance()
                when (method.first.isBlank() ||
                        sender.hasPermission(method.first)
                    ) {
                    true -> executeCommand(method.second, instance, sender, command, label, args)
                    else -> sender.msg(permissionMsg)
                }

                true
            }
        }
    }

    private fun executeCommand(
        method: Method?,
        instance: Any?,
        sender: CommandSender,
        cmd: Command,
        label: String,
        args: Array<String>
    ) = GlobalScope.launch {
        method?.invoke(instance, sender, cmd, label, args)
    }
}
