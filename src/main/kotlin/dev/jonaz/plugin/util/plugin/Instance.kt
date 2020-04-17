package dev.jonaz.plugin.util.plugin

import org.bukkit.plugin.java.JavaPlugin

class Instance(javaPlugin: JavaPlugin) {
    companion object {
        lateinit var plugin: JavaPlugin
    }

    init {
        plugin = javaPlugin
    }
}
