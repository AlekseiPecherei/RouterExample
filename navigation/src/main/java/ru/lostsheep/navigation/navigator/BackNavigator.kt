package ru.lostsheep.navigation.navigator

import android.app.Activity

/**
 * RouterExample
 * Created by lostsheep on 26.09.18:11:52.
 */
class BackNavigator(activity: Activity) : NavigatorExt(activity) {
    init {
        addBack()
    }
}