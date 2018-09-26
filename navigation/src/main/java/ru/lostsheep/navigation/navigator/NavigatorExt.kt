package ru.lostsheep.navigation.navigator

import android.app.Activity
import ru.lostsheep.navigation.Navigator
import ru.lostsheep.navigation.behavior.*
import ru.lostsheep.navigation.commands.Command
import java.util.*

/**
 * RouterExample
 * Created by lostsheep on 26.09.18:11:48.
 */
open class NavigatorExt(private val activity: Activity) : Navigator {
    private val behaviours = ArrayList<CommandBehaviour>()

    fun addBack(): NavigatorExt {
        addBehaviour(BackBehaviour())
        return this
    }

    fun addForward(key: String?, c: Class<*>): NavigatorExt {
        addBehaviour(ForwardBehaviour(key, c))
        return this
    }

    fun addForwardAsNewTask(key: String?, c: Class<*>): NavigatorExt {
        addBehaviour(ForwardBehaviourAsNewTask(key, c))
        return this
    }

    fun addForwardToWeb(key: String?): NavigatorExt {
        addBehaviour(ForwardToWeb(key))
        return this
    }

    fun addForwardWithBundle(key: String?, c: Class<*>): NavigatorExt {
        addBehaviour(ForwardBehaviourWithBundle(key, c))
        return this
    }

    fun addForwardWithResult(key: String?, c: Class<*>): NavigatorExt {
        addBehaviour(ForwardBehaviourWithResult(key, c))
        return this
    }

    fun addForwardWithBundleAndResult(key: String?, c: Class<*>): NavigatorExt {
        addBehaviour(ForwardBehaviourWithBundleAndResult(key, c))
        return this
    }

    fun addReplace(key: String?, action: Runnable): NavigatorExt {
        addBehaviour(ReplaceBehaviour(key, action))
        return this
    }

    override fun applyCommand(command: Command) {
        for (behaviour in behaviours) {
            behaviour.exec(activity, command)
        }
    }

    private fun addBehaviour(behaviour: CommandBehaviour) {
        behaviours.add(behaviour)
    }
}