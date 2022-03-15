package com.example.mobigicapp.screen

import android.view.animation.OvershootInterpolator
import android.window.SplashScreen
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mobigicapp.R
import com.example.mobigicapp.model.DataModel
import com.example.mobigicapp.navigation.MobigicScreen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController,dataModel:DataModel) {
    val scale = remember {
        Animatable(0f)

    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(targetValue = 0.5f,
            animationSpec = tween(durationMillis = 500,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }))
        delay(3000L)
        navController.navigate(MobigicScreen.FirstScreen.name)



    }

    Column(horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,
    modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF0D2821))){
            Image(painter = painterResource(id = R.drawable.mobijgiclogo),
                contentDescription = "SlapScreen",
                modifier = Modifier
                    .width(500.dp)
                    .height(500.dp)
                    .scale(scale.value))

        }

    }

    }
