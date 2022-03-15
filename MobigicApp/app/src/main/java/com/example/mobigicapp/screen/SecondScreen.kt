package com.example.mobigicapp.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mobigicapp.model.DataModel
import com.example.mobigicapp.navigation.MobigicScreen
import com.example.mobigicapp.userComponet.UserInput

@ExperimentalComposeUiApi
@Composable
fun SecondScreen(navController: NavController,dataModel: DataModel){
    var title by remember {
        mutableStateOf("")
    }


    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        UserInput(
            modifier = Modifier.padding(
                top = 18.dp , bottom = 16.dp
            ),
            text =  title, label = "UserInput",
            onTextChange = {
                if (it.all { char ->
                        char.isLetter() || char.isWhitespace()
                    }) title = it
            })

        Button(onClick = {
            dataModel.userinputString = title
            navController.navigate(MobigicScreen.ThirdScreen.name) },

            shape = CircleShape,
            elevation = ButtonDefaults.elevation(0.dp,0.dp),
            contentPadding = PaddingValues(20.dp,12.dp),
            border = BorderStroke(2.dp, MaterialTheme.colors.primary),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Transparent,contentColor = MaterialTheme.colors.primary)

        ) {
            Text(text = "Save")
        }
    }





}