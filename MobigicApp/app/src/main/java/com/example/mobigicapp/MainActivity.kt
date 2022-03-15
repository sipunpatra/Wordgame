package com.example.mobigicapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.tooling.preview.Preview
import com.example.mobigicapp.model.DataModel
import com.example.mobigicapp.navigation.MobigicNavigation
import com.example.mobigicapp.ui.theme.MobigicAppTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalFoundationApi
@ExperimentalComposeUiApi
@ExperimentalComposeApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           MobigicApp()
            }
        }
    }


@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@ExperimentalComposeApi
@Composable
fun MobigicApp(){
    MobigicAppTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            val dataModel = DataModel()
            MobigicNavigation(dataModel )
        }

    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MobigicAppTheme() {

    }
}
