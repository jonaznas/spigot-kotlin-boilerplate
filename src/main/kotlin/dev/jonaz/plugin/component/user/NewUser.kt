package dev.jonaz.plugin.component.user

import dev.jonaz.plugin.model.database.UsersModel
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction

class NewUser(private val name: String) {

    fun insertByName() = transaction {
        UsersModel.insert {
            it[username] = name
            it[password] = "idk"
        } get UsersModel.id
    }
}
