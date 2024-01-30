package com.example.worklazy

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.worklazy.R

import com.example.worklazy.ui.components.CircleButton
import com.example.worklazy.ui.theme.WorkLazyTheme
import kotlin.properties.Delegates

class MainActivity : ComponentActivity() {
    private lateinit var mediaPlayer: MediaPlayer
    private var tocando=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeMediaPlayer()

        setContent {
            WorkLazyTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AudioPlayerScreen(::Tocar)
                }
            }
        }
    }

    private fun initializeMediaPlayer() {
        mediaPlayer = MediaPlayer.create(this, R.raw.music)
    }

    private fun Tocar(){
        if(tocando){
            Parar()
        }else{
            playAudio()
        }
        tocando=!tocando
    }
    private fun playAudio() {
        mediaPlayer.start()

    }
    private fun Parar() {
        mediaPlayer.stop()
        mediaPlayer.release()
        initializeMediaPlayer()
        // Criar uma nova instância para futuras reproduções
    }
}

@Composable
fun AudioPlayerScreen(onClick: () -> Unit) {
    Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        CircleButton(
            onClick = onClick,
            text = "Trabalhe Vagabundo"

        )
    }
}

@Preview(showBackground = true)
@Composable
fun AudioPlayerScreenPreview() {
    WorkLazyTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            AudioPlayerScreen{}
        }
    }
}