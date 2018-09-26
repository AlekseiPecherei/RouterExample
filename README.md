# RouterExample
it's lightweight kotlin library that makes the navigation in an Android app easy.

[![](https://jitpack.io/v/AlekseiPecherei/RouterExample.svg)](https://jitpack.io/#AlekseiPecherei/RouterExample)

# Integration

Step 1. Add it in your root build.gradle at the end of repositories
```gradle
allprojects {
    repositories {
        ... 
        maven { url 'https://jitpack.io' }
    }
}
```

Step 2. Add the dependency
```gradle
dependencies {
    implementation 'com.github.AlekseiPecherei:RouterExample:v1.0'
}
```

Step 3. Initialize the library in your application class
```kotlin
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
```

Step 4. Place Navigator into your Activities:
```kotlin
abstract class AbsActivity : Activity() {
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
```

Step 5. Place Router into your presentation code
```kotlin
    protected var router = App.router    
```
and use Router manually
