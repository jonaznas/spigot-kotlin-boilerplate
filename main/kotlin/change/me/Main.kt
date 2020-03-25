@file:Suppress("unused")

package change.me

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
    private val cmdInitializer = CommandInitializer()

    override fun onEnable() {
        //config.setDefaultValues()
        database.connect()
        cmdInitializer.defineCommands()
        Bukkit.getLogger().info("Plugin enabled")
    }
}
