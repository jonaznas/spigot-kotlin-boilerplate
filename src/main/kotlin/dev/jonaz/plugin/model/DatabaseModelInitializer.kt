package dev.jonaz.plugin.model

import dev.jonaz.plugin.model.database.UsersModel
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

class DatabaseModelInitializer {

    fun createSchema() = transaction {
        SchemaUtils.create(
            UsersModel
        )
    }
}
