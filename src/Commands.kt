package plugin

import plugin.commands.Abc
import plugin.services.Instance

class Commands {
    private val plugin = Instance.plugin

    fun register() {

        plugin.getCommand("abc").executor = Abc

    }
}
