package dev.jonaz.plugin.util.exposed

import dev.jonaz.plugin.config.HikariConfiguration
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database

class DatabaseInitializer {
    private val dataSource: HikariDataSource

    init {
        val hikariConfig = HikariConfiguration().get()
        dataSource = HikariDataSource(hikariConfig)
    }

    fun connect() = Database.connect(dataSource)
}
