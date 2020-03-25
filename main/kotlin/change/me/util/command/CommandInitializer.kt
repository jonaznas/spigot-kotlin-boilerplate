package change.me.util.command

import change.me.util.plugin.Instance
import hazae41.minecraft.kutils.bukkit.schedule
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.reflections.Reflections
import org.reflections.scanners.MethodAnnotationsScanner
import java.lang.reflect.Method

class CommandInitializer {

    fun defineCommands() {
        val reflections = Reflections("change.me.command", MethodAnnotationsScanner())
        val annotated = reflections.getMethodsAnnotatedWith(CommandMapping::class.java)

        for (method in annotated) {
            val instance = method.declaringClass.getDeclaredConstructor().newInstance()
            val cmd = method.getAnnotation(CommandMapping::class.java).cmd

            Instance.plugin.getCommand(cmd).executor = CommandExecutor { sender, command, label, args ->
                executeCommand(method, instance, sender, command, label, args)
                true
            }
        }
    }

    private fun executeCommand(
        method: Method,
        instance: Any,
        sender: CommandSender,
        cmd: Command,
        label: String,
        args: Array<String>
    ) {
        Instance.plugin.schedule(async = true) { method.invoke(instance, sender, cmd, label, args) }
    }
}
