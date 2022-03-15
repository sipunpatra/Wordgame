package com.example.mobigicapp.navigation

 enum class MobigicScreen {
    SplashScreen,
     FirstScreen,
    SecondScreen,
    ThirdScreen;

    companion object{
        fun fromRoute(route : String?) : MobigicScreen
                = when (route?.substringBefore("/")){
            SplashScreen.name ->   SplashScreen
            FirstScreen.name -> FirstScreen
            SecondScreen.name -> SecondScreen
            ThirdScreen.name -> ThirdScreen
            null -> FirstScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }

}