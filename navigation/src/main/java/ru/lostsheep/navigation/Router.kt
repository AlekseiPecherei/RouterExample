package ru.lostsheep.navigation

import ru.lostsheep.navigation.commands.Back
import ru.lostsheep.navigation.commands.Forward
import ru.lostsheep.navigation.commands.Replace

/**
 * RouterExample
 * Created by lostsheep on 26.09.18:10:56.
 */
class Router : BaseRouter() {

    fun navigateTo(screenKey: String, data: Any? = null) {
        executeCommand(Forward(screenKey, data))
    }

    fun replaceScreen(screenKey: String, data: Any? = null) {
        executeCommand(Replace(screenKey, data))
    }

    fun exit() {
        executeCommand(Back())
    }
}