@file:Suppress("unused")

package dev.jonaz

import dev.jonaz.model.DatabaseModelInitializer
import dev.jonaz.util.command.CommandInitializer
import dev.jonaz.util.exposed.DatabaseInitializer
import dev.jonaz.util.plugin.Instance
import dev.jonaz.util.plugin.PluginConfig
import hazae41.minecraft.kutils.bukkit.info
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    private val instance = Instance(this)
    private val config = PluginConfig()
    private val database = DatabaseInitializer()
    private val databaseModel = DatabaseModelInitializer()
    private val cmdInitializer = CommandInitializer()

    override fun onEnable() {
        database.connect()
        databaseModel.createSchema()
        cmdInitializer.defineCommands()
        info("Plugin enabled")
    }
}
