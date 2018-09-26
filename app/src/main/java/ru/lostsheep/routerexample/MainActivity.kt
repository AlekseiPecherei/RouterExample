package ru.lostsheep.routerexample

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import ru.lostsheep.navigation.Navigator
import ru.lostsheep.navigation.navigator.BackNavigator

class MainActivity : AbsActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            router.navigateTo("second")
        }
    }

    override fun navigator(): Navigator? {
        return BackNavigator(this)
                .addForward("second", SecondActivity::class.java)
    }
}
