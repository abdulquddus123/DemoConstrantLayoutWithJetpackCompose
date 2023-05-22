package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(text = "Text one")
                        Text(text = "Text two")
                        Text(text = "Text three")

                        ConstrantLayoutDesign()


                        Text(text = "Text four")
                        Text(text = "Text five")
                    }

                }
            }
        }
    }
}

@Preview
@Composable
fun ConstrantLayoutDesign() {
    ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
        var text = createRef()
        val button = createRef()
        val button1 = createRef()
        Button(onClick = { }, modifier = Modifier.constrainAs(button) {
            top.linkTo(parent.top, margin = 16.dp)
        }
        ) {
            Text(text = "Button")
        }

        Text(text = "text", modifier = Modifier.constrainAs(text) {
            top.linkTo(button.top)
            start.linkTo(button.end)
            bottom.linkTo(button.bottom)

        })
        Button(onClick = {}, modifier = Modifier.constrainAs(button1){
            end.linkTo(parent.end)
            top.linkTo(button.top)

        }) {
            Text(text = "Button One")

        }
    }
}

