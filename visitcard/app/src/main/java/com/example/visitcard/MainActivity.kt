package com.example.visitcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.visitcard.ui.theme.VisitcardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VisitcardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFE0E0E0)
                ){
                    VisitCardApp()
                }
            }
        }
    }
}
@Composable
private fun VisitCardApp() {
    VisitCard(
        name = stringResource(R.string.ana_ushtanit),
        image = painterResource(R.drawable.android_logo),
        mail = stringResource(R.string.aushtanit_gmail_com)


    )
}




@Composable
fun VisitCard(
    mail: String,
    name: String,
    image: Painter,
    modifier: Modifier = Modifier,


    ) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = null,
        )
        Text(
            text = name,
        )
        Text(
            text = mail,
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VisitcardTheme {
        VisitCardApp()
    }
}