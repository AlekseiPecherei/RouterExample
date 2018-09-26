package ru.lostsheep.navigation.behavior

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import ru.lostsheep.navigation.commands.Command
import ru.lostsheep.navigation.commands.Forward

/**
 * RouterExample
 * Created by lostsheep on 26.09.18:11:41.
 */
class ForwardBehaviourWithBundle(
        private val key: String?,
        private val actTo: Class<*>) : CommandBehaviour {

    override fun exec(from: Activity, command: Command): Boolean {
        if (command is Forward) {
            val sKey = command.screenKey
            if (key != null && key != sKey) {
                return false
            }
            val args = command.transitionData as Bundle
            val intent = Intent(from, actTo)
            intent.putExtras(args)
            from.startActivity(intent)
        }
        return true
    }
}