package com.staynight.lab1

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InitScreen()
        }
    }
}

@Composable
fun InitScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.SpaceAround
    ) {
        MusicButton(letter = "A", color = R.color.violet, modifier = Modifier.weight(1f))
        MusicButton(letter = "B", color = R.color.indigo, modifier = Modifier.weight(1f))
        MusicButton(letter = "C", color = R.color.blue, modifier = Modifier.weight(1f))
        MusicButton(letter = "D", color = R.color.green, modifier = Modifier.weight(1f))
        MusicButton(letter = "E", color = R.color.yellow, modifier = Modifier.weight(1f))
        MusicButton(letter = "F", color = R.color.orange, modifier = Modifier.weight(1f))
        MusicButton(letter = "G", color = R.color.red, modifier = Modifier.weight(1f))
    }
}

private var buttonPadding = 17

@Composable
fun MusicButton(
    modifier: Modifier = Modifier, letter: String, color: Int
) {
    buttonPadding += 3
    val context = LocalContext.current
    val player = MediaPlayer.create(
        context, context.resources.getIdentifier(letter.lowercase(), "raw", context.packageName)
    )
    Button(
        onClick = {
            player.start()
        }, colors = ButtonDefaults.buttonColors(
            backgroundColor = colorResource(id = color)
        ), modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = buttonPadding.dp)
            .padding(vertical = 5.dp)
    ) {
        Text(
            text = letter,
            modifier.align(Alignment.CenterVertically),
            textAlign = TextAlign.Center,
            style = TextStyle(
                color = colorResource(id = R.color.white)
            )
        )
    }
}