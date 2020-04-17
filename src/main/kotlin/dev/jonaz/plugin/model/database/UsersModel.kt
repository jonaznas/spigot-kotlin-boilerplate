package dev.jonaz.plugin.model.database

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.`java-time`.datetime
import java.time.LocalDateTime

object UsersModel : Table("users") {
    val id = integer("id").autoIncrement()

    val username = text("username")
    val password = text("password")
    val created = datetime("createdAt").default(LocalDateTime.now())

    override val primaryKey = PrimaryKey(id, name = "id")
}
