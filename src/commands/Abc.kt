package plugin.commands

import hazae41.minecraft.kutils.bukkit.msg
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import plugin.services.Mysql
import org.bukkit.command.Command
import org.bukkit.command.CommandSender

object Abc {
    private val mysql = Mysql()

    operator fun invoke(sender: CommandSender?, command: Command?, label: String?, args: Array<String>?) {
        val myData = getSomeData()
        sender?.msg("&bThis is the test command")
        sender?.msg("&bThe SQL Result is: &e$myData")
    }

    private fun getSomeData(): String = runBlocking {
        val query = async {
            mysql.query("select * from mytable where id = ? limit 1", listOf(10))
            { pstmt ->
                val rs = pstmt.resultSet
                rs.next()
                return@query rs.getString("username") // return the value you want to use after the query
            }
        }
        return@runBlocking query.await() as String // here you get the value from above
    }
}
