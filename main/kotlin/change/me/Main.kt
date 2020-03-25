@file:Suppress("unused")

package change.me

import change.me.model.DatabaseModelInitializer
import change.me.util.command.CommandInitializer
import change.me.util.exposed.DatabaseInitializer
import change.me.util.plugin.Instance
import change.me.util.plugin.PluginConfig
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
