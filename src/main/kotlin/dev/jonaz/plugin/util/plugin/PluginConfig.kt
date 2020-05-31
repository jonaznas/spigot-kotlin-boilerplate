package dev.jonaz.plugin.util.plugin

import org.bukkit.configuration.file.FileConfiguration

class PluginConfig {
    private val plugin = Instance.plugin
    private val config: FileConfiguration = plugin.config

    init {
        setDefaultValues()
    }

    private fun setDefaultValues() {
        /**
         * Do NOT type any sensitive data here!
         * These are only default values.
         * Use the created config.yml
         */
        config.addDefault("database.host", "127.0.0.1")
        config.addDefault("database.port", "5432")
        config.addDefault("database.user", "username")
        config.addDefault("database.pass", "password")
        config.addDefault("database.name", "database")
        config.set("errors.permission", "You cant do that")
        save()
    }

    private fun save() {
        config.options().copyDefaults(true)
        plugin.saveConfig()
    }
}
