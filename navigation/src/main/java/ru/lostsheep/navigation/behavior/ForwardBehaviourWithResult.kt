package ru.lostsheep.navigation.behavior

import android.app.Activity
import android.content.Intent
import ru.lostsheep.navigation.commands.Command
import ru.lostsheep.navigation.commands.Forward

/**
 * RouterExample
 * Created by lostsheep on 26.09.18:11:42.
 */
class ForwardBehaviourWithResult(
        private val key: String?,
        private val actTo: Class<*>) : CommandBehaviour {

    override fun exec(from: Activity, command: Command): Boolean {
        if (command is Forward) {
            val sKey = command.screenKey
            if (key != null && key != sKey) {
                return false
            }
            val intent = Intent(from, actTo)
            val requestCode = command.transitionData as Int
            from.startActivityForResult(intent, requestCode)
        }
        return true
    }
}