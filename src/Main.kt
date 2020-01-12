package plugin

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import plugin.services.Config
import plugin.services.Instance

class Main : JavaPlugin() {
    override fun onEnable() {
        Instance(this)
        Config()
        Commands()
        Bukkit.getLogger().info("Plugin enabled")
    }
}
