package com.example.mobigicapp.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mobigicapp.components.InputField
import com.example.mobigicapp.model.DataModel
import com.example.mobigicapp.navigation.MobigicScreen

@ExperimentalComposeUiApi
@Composable
fun FirstScreen(navController: NavController,dataModel: DataModel,
                modifier: Modifier= Modifier,
                onValChange: (String) -> Unit ={}) {
    val NumberOfRaws = remember {
        mutableStateOf("")
    }

    val NumberOfColumn = remember {
        mutableStateOf("")
    }
    val keyboardController = LocalSoftwareKeyboardController.current

    val validState = remember(NumberOfRaws.value) {
        NumberOfRaws.value.trim().isNotEmpty()
    }


    Surface(
        modifier = modifier
            .padding(2.dp)
            .fillMaxWidth(),

    ) {
        Column(
            modifier = Modifier.padding(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {

            InputField(
                valueState = NumberOfRaws,
                lableId = "Rows",
                enabled = true,
                isSingleLine = true,
                onAction = KeyboardActions {
                    if (!validState) return@KeyboardActions
                    onValChange(NumberOfRaws.value.trim())

                    keyboardController?.hide()
                },
            )
        }
    }
    Row(
        modifier = modifier
            .padding(horizontal = 0.dp, vertical = 150.dp))
    {
        Surface(
            modifier = modifier
                .padding(2.dp)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(30.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                InputField(
                    valueState = NumberOfColumn,
                    lableId = "Column",
                    enabled = true,
                    isSingleLine = true,
                    onAction = KeyboardActions {
                        if (!validState) return@KeyboardActions
                        onValChange(NumberOfRaws.value.trim())
                        keyboardController?.hide()
                    })

            }
        }
    }
    Row(
        modifier = modifier
            .padding(
                horizontal = 150.dp,
                vertical = 300.dp
            )
    ) {
        Button(
            onClick = {
                dataModel.rows = NumberOfRaws.value.toInt()
                dataModel.columns = NumberOfColumn.value.toInt()

                navController.navigate(MobigicScreen.SecondScreen.name)
            },

            modifier = modifier,
            shape = CircleShape,
            elevation = ButtonDefaults.elevation(0.dp,0.dp),
            contentPadding = PaddingValues(20.dp,12.dp),
            border = BorderStroke(2.dp,MaterialTheme.colors.primary),
            colors =ButtonDefaults.buttonColors(backgroundColor = Color.Transparent,contentColor = MaterialTheme.colors.primary)
        ) {
            Text(text = "Next")

        }
    }
}




