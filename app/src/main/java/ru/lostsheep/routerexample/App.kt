package ru.lostsheep.routerexample

import android.app.Application
import ru.lostsheep.navigation.Navigation
import ru.lostsheep.navigation.NavigationHolder
import ru.lostsheep.navigation.Router

/**
 * RouterExample
 * Created by lostsheep on 26.09.18:11:55.
 */
class App : Application() {

    companion object {
        private var navigation: Navigation<Router>? = null

        val navigatorHolder: NavigationHolder
            get() = navigation!!.getNavigationHolder()

        val router: Router
            get() = navigation!!.getRouter()

    }

    override fun onCreate() {
        super.onCreate()
        navigation = Navigation.create()
    }
}