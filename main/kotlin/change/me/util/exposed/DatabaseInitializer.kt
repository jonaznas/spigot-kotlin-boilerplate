package change.me.util.exposed

import change.me.config.HikariConfiguration
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
