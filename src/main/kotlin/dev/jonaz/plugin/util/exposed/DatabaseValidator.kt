package dev.jonaz.plugin.util.exposed

import dev.jonaz.plugin.util.plugin.Instance
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
            dbHost -> Pair(false, "database.host")
            dbName -> Pair(false, "database.name")
            dbUser -> Pair(false, "database.user")
            dbPass -> Pair(false, "database.pass")
            else -> Pair(true, "")
        }
    }
}
