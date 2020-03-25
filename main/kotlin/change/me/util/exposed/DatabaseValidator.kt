package change.me.util.exposed

import org.bukkit.Bukkit
import kotlin.system.exitProcess

class DatabaseValidator(
    private val dbHost: String?,
    private val dbName: String?,
    private val dbUser: String?,
    private val dbPass: String?
) {

    fun validateEnvironment() {
        val valuesExist = checkExist()

        if (!valuesExist.first) {
            Bukkit.getLogger().warning("Database variable \"${valuesExist.second}\" is undefined")
        }
    }

    private fun checkExist(): Pair<Boolean, String> {
        return when (null) {
            dbHost -> Pair(false, "database.host")
            dbName -> Pair(false, "database.name")
            dbUser -> Pair(false, "database.user")
            dbPass -> Pair(false, "database.pass")
            else -> Pair(true, "")
        }
    }
}
