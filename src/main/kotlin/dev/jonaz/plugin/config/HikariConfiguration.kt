package dev.jonaz.plugin.config

import dev.jonaz.plugin.util.exposed.DatabaseValidator
import dev.jonaz.plugin.util.plugin.Instance
import com.zaxxer.hikari.HikariConfig

class HikariConfiguration {
    private val config = HikariConfig()
    private val plugin = Instance.plugin

    private val dbHost: String? = plugin.config.getString("database.host")
    private val dbPort: String? = plugin.config.getString("database.port") ?: "5432"
    private val dbName: String? = plugin.config.getString("database.name")
    private val dbUser: String? = plugin.config.getString("database.user")
    private val dbPass: String? = plugin.config.getString("database.pass")

    init {
        DatabaseValidator(
            dbHost, dbName, dbUser, dbPass
        ).validateConfigValues()

        val url = "jdbc:postgresql://$dbHost:$dbPort/$dbName"
        Class.forName("org.postgresql.Driver")

        config.jdbcUrl = url
        config.username = dbUser
        config.password = dbPass
    }

    fun get(): HikariConfig = config
}
