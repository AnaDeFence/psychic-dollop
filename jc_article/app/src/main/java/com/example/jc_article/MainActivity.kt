package com.example.jc_article

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign.Companion.Justify
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                            header = stringResource(R.string.jetpack_compose_header),
                            text1 = stringResource(R.string.jetpack_compose_text1),
                            text2 = stringResource(R.string.jetpack_compose_text2)


                        )
                    }

            }
        }
    }
}

@Composable
fun ArticleCard(
    header: String,
    text1:String,
    text2:String,
    modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)

    Column(modifier=modifier){
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Text(
            text = header,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = text1,
            textAlign = Justify,
            modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
        )
        Text(
            text = text2,
            textAlign = Justify,
            modifier = Modifier.padding(16.dp)

        )
    }


}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Jc_articleTheme {
        ArticleCard(
            header = stringResource(R.string.jetpack_compose_header),
            text1 = stringResource(R.string.jetpack_compose_text1),
            text2 = stringResource(R.string.jetpack_compose_text2)
        )
    }
}