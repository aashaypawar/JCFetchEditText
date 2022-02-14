package com.geeksforgeeks.fetchedittext

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent()
        }
    }
}

@Composable
fun MainContent(){
    Scaffold(
        topBar = {TopAppBar(
            title = {Text(
                "GFG | TextField Fetch Data",
                color = Color.White)},
            backgroundColor = Color(0xff0f9d58)) },
        content = { MyContent()}
    )
}

@Composable
fun MyContent(){
    val mContent = LocalContext.current
    var mText by remember { mutableStateOf("") }

    Column(Modifier.fillMaxWidth()) {
        TextField(
            value = mText,
            onValueChange = { mText = it },
            label = { Text("Enter something...") },
            modifier = Modifier
                .fillMaxWidth()
                .absolutePadding(10.dp, 100.dp, 10.dp, 0.dp)
        )
    }

    Box(Modifier.fillMaxSize(), Alignment.Center){
        Button(onClick = { Toast.makeText(mContent, mText, Toast.LENGTH_LONG).show() },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0XFF0F9D58))) {
            Text(text = "Click", color = Color.White)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainContent()
}