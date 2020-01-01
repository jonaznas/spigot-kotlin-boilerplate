package plugin.commands

import hazae41.minecraft.kutils.bukkit.msg
import plugin.services.Mysql
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

object Abc : CommandExecutor {
    override fun onCommand(sender: CommandSender?, command: Command?, label: String?, args: Array<out String>?): Boolean {
        val mysql = Mysql()
        mysql.query("select * from mytable where id = ? limit 1", listOf(10))
        { result ->
            result.next()
            /** Get column by name **/
            // result.getString("columnname")

            /** Get last insert id **/
            // result.getInt(1).toString()
        }

        sender?.msg("&bThis is the test command")

        return true
    }
}
