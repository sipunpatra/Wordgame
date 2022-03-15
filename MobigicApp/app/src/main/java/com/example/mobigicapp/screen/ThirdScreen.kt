package com.example.mobigicapp.screen

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.mobigicapp.model.DataModel
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobigicapp.userComponet.UserInput

@ExperimentalFoundationApi
@ExperimentalComposeUiApi

@Composable
fun ThirdScreen(navController: NavController,dataModel: DataModel){
    var title by remember {
        mutableStateOf("")
    }
    Log.d("ThirdScreen ", dataModel.userinputString)
    val rows = dataModel.rows
    val columns =dataModel.columns
    val userInput = dataModel.userinputString
    val colorInputState = remember {
        mutableStateOf(IntArray(userInput.length))
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        ) {
        LazyVerticalGrid(
            cells = GridCells.Fixed(columns),
            contentPadding = PaddingValues(
                start = 12.dp,
                top = 16.dp,
                end =12.dp,
                bottom = 16.dp
            )
        )
         {
            items(userInput.length) {
               Card(backgroundColor = Color.Green,
                   modifier = Modifier
                       .padding(4.dp)
                       .fillMaxWidth(),
                   elevation = 8.dp

                   ) {


                    // Text(text = "Number " + rows )

                    Text(text = "${userInput.get(it)}",
                        fontWeight = FontWeight.Bold,
                        fontSize =30.sp,
                        textAlign = TextAlign.Center,
                        modifier =Modifier.padding(16.dp),
                        color = getColor(colorInputState.value[it])


                    )

                }

            }
        }
     UserInput(
            modifier = Modifier.padding(
                top = 18.dp, bottom = 16.dp
            ),
            text = title, label = "Check word",
            onTextChange = {
                if (it.all { char ->
                        char.isLetter() || char.isWhitespace()
                    }) title = it
                refreshState(colorInputState)
                checkHoizontal(title, userInput, rows, columns, colorInputState)
                checkVertical(title, userInput, rows, columns, colorInputState)
                checkDiagonal(title, userInput)
            })

    }

}

fun getColor(index:Int):Color{
    if(index == 0) return Color.Red
    else return Color.Blue
}

fun refreshState(colorInputState: MutableState<IntArray>){
    for(i in 0..colorInputState.value.size -1){
        colorInputState.value[i] = 0
    }
}

fun checkHoizontal(word:String,userInput:String,row:Int,col:Int,colorInputState:MutableState<IntArray>) {



    var strList:ArrayList<String> = ArrayList()
    for (j in 0..col - 1) {
        var str = ""
        for (i in 0..row - 1) {
            Log.d("checkHorizontal $i , $j ,$row,$col", userInput[i + (j * row)].toString())
            str = str + userInput[i + (j * row)].toString()
        }
        Log.d("checkHorizontal",str)
        strList.add(str)

    }
    for(str in strList){
        val index = matchDetails(str,word,0)
        if(index>=0) {
            val finalIndex = strList.indexOf(str)
            // check should u increment by 1??
            val s =  finalIndex*col + index
            highlightCellsHorizontal(s,word.length,colorInputState)
        }

    }

}

fun highlightCellsHorizontal(startIndex:Int, length:Int,colorInputState: MutableState<IntArray>){
    for(l in startIndex..startIndex+length-1)
        colorInputState.value[l] = 1
}
fun matchDetails(inputString: String, whatToFind: String, startIndex: Int = 0): Int {
    val matchIndex = inputString.indexOf(whatToFind, startIndex)
    val rs =  "Searching for '$whatToFind' in '$inputString' starting at position $startIndex: " +
            if (matchIndex >= 0) "Found at $matchIndex" else "Not found"
    return matchIndex
}




fun checkVertical(word:String,userInput: String,row:Int,col:Int,colorInputState: MutableState<IntArray>){


    var strList:ArrayList<String> = ArrayList()
    for (j in 0..row - 1) {
        var str = ""
        for (i in 0..col- 1) {
            Log.d("checkHorizontal $i , $j ,$row,$col", userInput[j + (i * col)].toString())
            str = str + userInput[j + (i * col)].toString()
        }
        Log.d("checkHorizontal",str)
        strList.add(str)

    }

    //handle this part ..error is here .. u need correct index calculation
    for(str in strList){
        val index = matchDetails(str,word,0)
        if(index>=0) {
            val finalIndex = strList.indexOf(str)
            // check should u increment by 1??
            val s =  finalIndex + index*col
            highlightCellsVertical(s,word.length,col,colorInputState)
        }

    }

}
fun highlightCellsVertical(startIndex:Int, length:Int,col:Int,colorInputState: MutableState<IntArray>){
    var l = startIndex
    var count = length
    while(count>0)
    {

        colorInputState.value[l] = 1
        l += col
        count --
    }
}

fun checkDiagonal(word:String,userInput: String){



}