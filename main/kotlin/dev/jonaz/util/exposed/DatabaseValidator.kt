package dev.jonaz.util.exposed

import dev.jonaz.util.plugin.Instance
import hazae41.minecraft.kutils.bukkit.warning

class DatabaseValidator(
    private val dbHost: String?,
    private val dbName: String?,
    private val dbUser: String?,
    private val dbPass: String?
) {
    private val plugin = Instance.plugin

    fun validateConfigValues() {
        val valuesExist = checkExist()

        if (!valuesExist.first) {
            plugin.warning("Database variable \"${valuesExist.second}\" is undefined")
        }
    }

    private fun checkExist(): Pair<Boolean, String> {
        return when (null) {
            dbHost -> Pair(false, "database_host")
            dbName -> Pair(false, "database_name")
            dbUser -> Pair(false, "database_user")
            dbPass -> Pair(false, "database_pass")
            else -> Pair(true, "")
        }
    }
}
