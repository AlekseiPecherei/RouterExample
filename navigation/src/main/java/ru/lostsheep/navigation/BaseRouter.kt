package ru.lostsheep.navigation

import ru.lostsheep.navigation.commands.Command

/**
 * RouterExample
 * Created by lostsheep on 26.09.18:10:52.
 */
abstract class BaseRouter {
    private val commandBuffer: Buffer = Buffer()

    fun getCommandBuffer(): Buffer = commandBuffer

    protected fun executeCommand(command: Command) {
        commandBuffer.executeCommand(command)
    }
}