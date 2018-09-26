package ru.lostsheep.navigation.behavior

import android.app.Activity
import ru.lostsheep.navigation.commands.Command

/**
 * RouterExample
 * Created by lostsheep on 26.09.18:11:35.
 */
interface CommandBehaviour {
    fun exec(from: Activity, command: Command): Boolean
}