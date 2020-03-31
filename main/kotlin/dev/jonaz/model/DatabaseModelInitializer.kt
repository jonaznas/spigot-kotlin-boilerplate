package dev.jonaz.model

import dev.jonaz.model.database.UsersModel
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

class DatabaseModelInitializer {

    fun createSchema() = transaction {
        SchemaUtils.create(
            UsersModel
        )
    }
}
