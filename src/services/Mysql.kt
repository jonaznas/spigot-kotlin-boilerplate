package plugin.services

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import hazae41.minecraft.kutils.bukkit.schedule
import org.bukkit.Bukkit
import org.bukkit.configuration.file.FileConfiguration
import java.sql.*
import java.sql.Date
import java.util.*
import javax.sql.DataSource

class Mysql {
    private var dbUser: String
    private var dbPass: String
    private var dbHost: String
    private var dbName: String
    private val plugin = Instance.plugin
    private val config: FileConfiguration = plugin.config

    init {
        this.dbUser = config.getString("database.user")
        this.dbPass = config.getString("database.pass")
        this.dbHost = config.getString("database.host")
        this.dbName = config.getString("database.name")
    }

    private val dataSource: DataSource = getDataSource()
    private fun getDataSource(): DataSource {
        val config = HikariConfig()
        config.jdbcUrl = "jdbc:mysql://${this.dbHost}/${this.dbName}"
        config.username = this.dbUser
        config.password = this.dbPass
        config.maximumPoolSize = 10
        config.isAutoCommit = false
        config.addDataSourceProperty("cachePrepStmts", "true")
        config.addDataSourceProperty("prepStmtCacheSize", "250")
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048")
        return HikariDataSource(config)
    }

    fun query(query: String, values: List<Any?>, callback: (ResultSet) -> Unit) {
        Instance.plugin.schedule(async = true) {
            val connection: Connection = dataSource.connection
            val pstmt: PreparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)
            try {
                values.forEachIndexed { i, e ->
                    when (e) {
                        is String -> pstmt.setString(i + 1, e)
                        is Int -> pstmt.setInt(i + 1, e)
                        is Long -> pstmt.setLong(i + 1, e)
                        is Double -> pstmt.setDouble(i + 1, e)
                        is Float -> pstmt.setFloat(i + 1, e)
                        is Blob -> pstmt.setBlob(i + 1, e)
                        is Boolean -> pstmt.setBoolean(i + 1, e)
                        is Date -> pstmt.setDate(i + 1, e)
                        is Objects -> pstmt.setObject(i + 1, e)
                        is Timestamp -> pstmt.setTimestamp(i + 1, e)
                        else -> {
                            Bukkit.getLogger().warning("Invalid mysql-value type converted to string on index $i ($e)")
                            pstmt.setString(i + 1, e.toString())
                        }
                    }
                }
                val rs = pstmt.execute()
                if (rs) {
                    callback(pstmt.resultSet)
                } else {
                    callback(pstmt.generatedKeys)
                }
                connection.commit()
            } catch (e: SQLException) {
                e.printStackTrace()
            } finally {
                try {
                    pstmt.close()
                    connection.close()
                } catch (e: SQLException) {
                    e.printStackTrace()
                }
            }
        }
    }
}
