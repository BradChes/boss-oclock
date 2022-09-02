package com.boss_oclock

import GsonParser
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.boss_oclock.ui.theme.BossoclockTheme
import com.parser.models.Meta
import com.parser.models.Phase

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val gsonParser = GsonParser()

        val thing  = gsonParser.getMetasResponse()

        setContent {
            BossoclockTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                    thing.forEach{
                            MetaCard(meta = it)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MetaCard(meta: Meta) {
    Column {
        Text(text = "name: ${meta.name}!")
        Text(text = "category: ${meta.category}!")
        Text(text = "phases:")
        Column {
        meta.phases.forEach {
                PhaseCard(it)
            }
        }
    }

}

@Composable
fun PhaseCard(phase: Phase) {
    Column {
        Text(text = "name: ${phase.name}")
        Text(text = "text: ${phase.text}!")
        Text(text = "duration: ${phase.duration}!")
        Text(text = "color: ${phase.color}!")
    }
}

//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    BossoclockTheme {
//        Greeting("Android")
//    }
//}