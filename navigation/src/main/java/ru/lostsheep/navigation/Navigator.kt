package ru.lostsheep.navigation

import ru.lostsheep.navigation.commands.Command

/**
 * RouterExample
 * Created by lostsheep on 26.09.18:10:21.
 */
interface Navigator {
    fun applyCommand(command: Command)
}