package ru.lostsheep.routerexample

import android.app.Activity
import ru.lostsheep.navigation.Navigator
import ru.lostsheep.navigation.navigator.BackNavigator

/**
 * RouterExample
 * Created by lostsheep on 26.09.18:12:12.
 */
abstract class AbsActivity : Activity() {
    protected var router = App.router

    override fun onResume() {
        super.onResume()
        App.navigatorHolder.setNavigator(navigator())
    }

    override fun onPause() {
        super.onPause()
        App.navigatorHolder.removeNavigator()
    }

    open fun navigator(): Navigator? {
        return BackNavigator(this)
    }
}