package ru.lostsheep.navigation.behavior

import android.app.Activity
import android.content.Intent
import ru.lostsheep.navigation.commands.Command
import ru.lostsheep.navigation.commands.Forward

/**
 * RouterExample
 * Created by lostsheep on 26.09.18:11:40.
 */
class ForwardBehaviourAsNewTask(
        private val key: String?,
        private val actTo: Class<*>) : CommandBehaviour {

    override fun exec(from: Activity, command: Command): Boolean {
        if (command is Forward) {
            val sKey = command.screenKey
            if (key != null && key != sKey) {
                return false
            }
            val intent = Intent(from, actTo)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            from.startActivity(intent)
            from.finish()
        }
        return true
    }
}