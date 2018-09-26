package ru.lostsheep.navigation.behavior

import android.app.Activity
import android.content.Intent
import android.net.Uri
import ru.lostsheep.navigation.commands.Command
import ru.lostsheep.navigation.commands.Forward

/**
 * RouterExample
 * Created by lostsheep on 26.09.18:11:42.
 */
class ForwardToWeb(private val key: String?) : CommandBehaviour {

    override fun exec(from: Activity, command: Command): Boolean {
        if (command is Forward) {
            val sKey = command.screenKey
            if (key != null && key != sKey) {
                return false
            }
            val url = command.transitionData as String
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            from.startActivity(intent)
        }
        return true
    }
}
