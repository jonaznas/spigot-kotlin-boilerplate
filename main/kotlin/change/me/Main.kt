@file:Suppress("unused")

package change.me

import change.me.model.DatabaseModelInitializer
import change.me.util.command.CommandInitializer
import change.me.util.exposed.DatabaseInitializer
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import change.me.util.plugin.PluginConfig
import change.me.util.plugin.Instance

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
        Bukkit.getLogger().info("Plugin enabled")
    }
}
