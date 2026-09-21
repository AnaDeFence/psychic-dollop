package com.example.task_manager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.task_manager.ui.theme.Task_managerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Task_managerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    ComposeTaskApp()
                }
            }
        }
    }
}

@Composable
fun ComposeTaskApp(){
    TaskCard(
        image = painterResource(R.drawable.ic_task_completed),
        header = stringResource(R.string.all_tasks_completed),
        maintext = stringResource(R.string.nice_work)

    )

}

@Composable
fun TaskCard(
    header: String,
    maintext: String,
    image: Painter,
    modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize(),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = image,
            contentDescription = null
        )
        Text(
            text = header,
            fontWeight = Bold,
            modifier = Modifier.padding(top = 24.dp,bottom = 8.dp)

        )
        Text(
            text = maintext,
            fontSize = 16.sp
        )
    }

}

@Preview(showBackground = true)
@Composable
fun TaskCardAppPreview() {
    Task_managerTheme {
        ComposeTaskApp()
    }
}