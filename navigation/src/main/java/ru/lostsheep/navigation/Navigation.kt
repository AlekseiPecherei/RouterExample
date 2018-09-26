package ru.lostsheep.navigation

/**
 * RouterExample
 * Created by lostsheep on 26.09.18:11:06.
 */
class Navigation<T : BaseRouter>(private val router: T) {

    fun getRouter(): T {
        return router
    }

    fun getNavigationHolder(): NavigationHolder {
        return router.getCommandBuffer()
    }

    companion object {
        fun create(): Navigation<Router> {
            return create(Router())
        }

        fun <T : BaseRouter> create(customRouter: T): Navigation<T> {
            return Navigation(customRouter)
        }
    }
}