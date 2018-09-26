package ru.lostsheep.navigation

import ru.lostsheep.navigation.commands.Command
import java.util.*

/**
 * RouterExample
 * Created by lostsheep on 26.09.18:10:28.
 */
class Buffer : NavigationHolder {
    private var navigator: Navigator? = null
    private val pendingCommands = LinkedList<Command>()

    override fun setNavigator(navigator: Navigator?) {
        this.navigator = navigator
        while (pendingCommands.isNotEmpty()) {
            if (navigator != null) {
                val command = pendingCommands.poll()
                executeCommand(command)
            } else {
                break
            }
        }
    }

    override fun removeNavigator() {
        this.navigator = null
    }

    fun executeCommand(command: Command) {
        if (navigator != null) {
            navigator!!.applyCommand(command)
        } else {
            pendingCommands.add(command)
        }
    }
}