package dev.jonaz.model.database

import org.jetbrains.exposed.sql.Table

object UsersModel : Table("users") {
    val id = integer("id")
            .autoIncrement()
            .primaryKey()
    val username = text("username")
    val password = text("password")
    val created = text("created")
}
