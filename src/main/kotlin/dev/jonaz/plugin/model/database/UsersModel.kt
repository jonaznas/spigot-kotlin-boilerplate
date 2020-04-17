package dev.jonaz.plugin.model.database

import org.jetbrains.exposed.sql.Table

object UsersModel : Table("users") {
    val id = integer("id").autoIncrement()

    val username = text("username")
    val password = text("password")
    val created = text("created")

    override val primaryKey = PrimaryKey(id, name = "id")
}
