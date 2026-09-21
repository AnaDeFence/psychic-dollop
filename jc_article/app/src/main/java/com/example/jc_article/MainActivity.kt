package com.example.jc_article

import android.R.id.text1
import android.R.id.text2
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.jc_article.ui.theme.Jc_articleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Jc_articleTheme {

                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        ArticleCard(
                            header = "",
                            text1 = "",
                            text2 = "",
                            text3 = ""

                        )
                    }

            }
        }
    }
}

@Composable
fun ArticleCard(header: String, text1:String, text2:String, text3:String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)

    Box(modifier){
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        GreetingText(
            header = header,
            text1 = text1,
            text2 = text2,
            text3 = text3,
            modifier = modifier
        )
    }


}

@Composable
fun GreetingText(header: String, text1: String, text2: String, text3:String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = header
        )
        Text(
            text = text1
        )
        Text(
            text = text2
        )
        Text(
            text = text3
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Jc_articleTheme {
        ArticleCard(
            header = "",
            text1 = "",
            text2 = "",
            text3 = ""
        )
    }
}