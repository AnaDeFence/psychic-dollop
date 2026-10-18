package com.example.lemonade1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade1.ui.theme.Lemonade1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lemonade1Theme {

                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeAppWithTopBar()
                }

            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeAppWithTopBar(
    modifier: Modifier = Modifier

){
    Scaffold(
        modifier = modifier,
        topBar = {
            CenterAlignedTopAppBar(               // ← вот замена
                title = { Text(stringResource(R.string.topbar)) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFFFF59D)
                )
            )
        }
    ) {
        innerPadding->
        LemonadeWithImages(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        )

    }

}


@Composable
fun LemonadeWithImages(modifier: Modifier = Modifier){

    var result by remember { mutableStateOf( 1) }
    var taps by remember { mutableStateOf(0) }
    var nededdtaps by remember { mutableStateOf(0) }
    val imageResource = when(result){
        1->R.drawable.lemon_tree
        2->R.drawable.lemon_squeeze
        3->R.drawable.lemon_drink
        else->R.drawable.lemon_restart
    }
    val stringRes = when(result){
        1->R.string.lemontree_content
        2->R.string.lemon_content
        3->R.string.lemonade_content
        else->R.string.glass_content
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {



            Image(

                painter = painterResource(imageResource),
                contentDescription = result.toString(),
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0xFFFFB6C1))
                    .border(
                        width = 2.dp,
                        color = Color(0xFFFFB6C1),
                        shape = RoundedCornerShape(10.dp)
                    )

                    .clickable{
                        when(result){
                            1->{
                                result=2
                                taps = 0
                                nededdtaps = (2..4).random()

                            }2->{
                                taps ++
                                if(taps>= nededdtaps){
                                    result=3
                                    taps=0
                                }
                            }3->result=4
                            4->result=1
                        }
                    }
            )


        Spacer(modifier= Modifier.height(16.dp))
        Text(
            text = stringResource(stringRes),
            fontSize = 18.sp
        )

    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    Lemonade1Theme{
        LemonadeAppWithTopBar()
    }
}