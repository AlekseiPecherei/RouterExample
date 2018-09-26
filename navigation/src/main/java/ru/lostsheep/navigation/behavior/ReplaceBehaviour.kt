package ru.lostsheep.navigation.behavior

import android.app.Activity
import ru.lostsheep.navigation.commands.Command
import ru.lostsheep.navigation.commands.Replace

/**
 * RouterExample
 * Created by lostsheep on 26.09.18:11:43.
 */
class ReplaceBehaviour(
        private val key: String?,
        private val action: Runnable) : CommandBehaviour {

    override fun exec(from: Activity, command: Command): Boolean {
        if (command is Replace) {
            val sKey = command.screenKey
            if (key != null && !key.isEmpty() && key != sKey) {
                return false
            }
            from.runOnUiThread(action)
        }
        return true
    }
}