package com.example.mobigicapp.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mobigicapp.model.DataModel
import com.example.mobigicapp.screen.FirstScreen
import com.example.mobigicapp.screen.SecondScreen
import com.example.mobigicapp.screen.SplashScreen
import com.example.mobigicapp.screen.ThirdScreen

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalComposeApi
@Composable
fun MobigicNavigation(dataModel: DataModel) {

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MobigicScreen.SplashScreen.name
    ) {
        composable(MobigicScreen.SplashScreen.name) {
            //first screen
            SplashScreen(navController = navController, dataModel)
        }
        composable(MobigicScreen.FirstScreen.name) {
//            second screen
            FirstScreen(navController = navController, dataModel)
        }
        composable(MobigicScreen.SecondScreen.name) {
            // third screen
            SecondScreen(navController = navController, dataModel)
        }
        composable(MobigicScreen.ThirdScreen.name) {
            // third screen
            ThirdScreen(navController = navController, dataModel)
        }
    }
}


