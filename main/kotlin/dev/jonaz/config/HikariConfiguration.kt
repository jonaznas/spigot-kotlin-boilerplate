package dev.jonaz.config

import dev.jonaz.util.exposed.DatabaseValidator
import dev.jonaz.util.plugin.Instance
import com.zaxxer.hikari.HikariConfig

class HikariConfiguration {
    private val config = HikariConfig()
    private val plugin = Instance.plugin

    private val dbHost: String? = plugin.config.getString("database_host")
    private val dbPort: String? = plugin.config.getString("database_port") ?: "5432"
    private val dbName: String? = plugin.config.getString("database_name")
    private val dbUser: String? = plugin.config.getString("database_user")
    private val dbPass: String? = plugin.config.getString("database_pass")

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
