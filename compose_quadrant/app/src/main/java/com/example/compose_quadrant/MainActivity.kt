package com.example.compose_quadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_quadrant.ui.theme.Compose_quadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Compose_quadrantTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeQuadrantApp()
                }
            }
        }
    }
}

@Composable
fun ComposeQuadrantApp(){
    QuadrantApp(


        )

}
@Composable
private fun QuadrantApp(



) {
    Column(
        Modifier.fillMaxWidth()

    ) {
        Row(
            modifier = Modifier.weight(1f)
        ) {
            Quadrant(
                modifier = Modifier
                    .weight(1f),
                header = stringResource(R.string.text_composable),
                descr = stringResource(R.string.text_comp_text),
                color = Color(0xFFEADDFF)
            )
            Quadrant(
                modifier = Modifier
                    .weight(1f),
                header = stringResource(R.string.image_composable),
                descr = stringResource(R.string.img_comp_text),
                color = Color(0xFFD0BCFF)
            )
        }
        Row(
            modifier = Modifier.weight(1F)
        ){
            Quadrant(
                modifier = Modifier
                    .weight(1f),
                header = stringResource(R.string.column_composable),
                descr = stringResource(R.string.col_comp_text),
                color = Color(0xFFB69DF8)
            )
            Quadrant(
                modifier =Modifier
                    .weight(1f),
                header = stringResource(R.string.row_composable),
                descr = stringResource(R.string.row_comp_text),
                color = Color(0xFFF6EDFF)

            )
        }
    }





}

@Composable
fun Quadrant(header: String,descr: String, color: Color, modifier: Modifier= Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color).padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = header,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)

        )
        Text(
            text = descr,
            textAlign = TextAlign.Justify
        )
    }





}





@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Compose_quadrantTheme {
        ComposeQuadrantApp()
    }
}