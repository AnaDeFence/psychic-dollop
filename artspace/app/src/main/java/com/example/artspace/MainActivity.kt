package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtspaceTheme
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.aspectRatio

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtspaceTheme {
                ArtSpaceApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArtSpaceApp() {
    // Номер текущей картины (от 1 до 7)
    var currentStep by remember { mutableStateOf(1) }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Art Space",
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            color = MaterialTheme.colorScheme.background
        ) {
            val imageRes = when (currentStep) {
                1 -> R.drawable.monaliza
                2 -> R.drawable.tainajavecherya
                3 -> R.drawable.venerahb
                4 -> R.drawable.adamcreating
                5 -> R.drawable.madonna
                6 -> R.drawable.arnolfini
                else -> R.drawable.humanpeachs
            }

            val titleRes = when (currentStep) {
                1 -> R.string.mona_lisa_title
                2 -> R.string.last_supper_title
                3 -> R.string.venus_birth_title
                4 -> R.string.adam_creation_title
                5 -> R.string.sistine_madonna_title
                6 -> R.string.arnolfini_portrait_title
                else -> R.string.garden_delights_title// Не забудь добавить этот текст в strings.xml!
            }

            val detailsRes = when (currentStep) {
                1 -> R.string.mona_lisa_details
                2 -> R.string.last_supper_details
                3 -> R.string.venus_birth_details
                4 -> R.string.adam_creation_details
                5 -> R.string.sistine_madonna_details
                6 -> R.string.arnolfini_portrait_details
                else -> R.string.garden_delights_details // И этот тоже!
            }

            ArtSpaceContent(
                imageRes = imageRes,
                titleRes = titleRes,
                detailsRes = detailsRes,
                onPreviousClick = {
                    currentStep = if (currentStep > 1) currentStep - 1 else 7
                },
                onNextClick = {
                    currentStep = if (currentStep < 7) currentStep + 1 else 1
                }
            )
        }
    }
}

@Composable
fun ArtSpaceContent(
    imageRes: Int,
    titleRes: Int,
    detailsRes: Int,
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // 1. Ограничиваем ширину картинки, чтобы на планшете она не была гигантской
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = stringResource(id = titleRes),
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth(0.8f) // Занимает 80% от доступной ширины
                .widthIn(max = 400.dp) // Но не больше 400dp (для планшетов)
                .aspectRatio(0.8f) // Сохраняет пропорции (высота чуть больше ширины)
                .background(Color.LightGray)
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 2. Текст тоже можно ограничить по ширине, чтобы он не растягивался на весь планшет
        Column(
            modifier = Modifier.widthIn(max = 400.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = titleRes),
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center,        // <-- Добавь это (выравнивание по центру)
                modifier = Modifier.fillMaxWidth()   // <-- И это (чтобы текст занимал всю ширину и центрировался)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = stringResource(id = detailsRes),
                fontSize = 16.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center, // <-- ВОТ ЭТА СТРОКА
                modifier = Modifier.fillMaxWidth() // <-- И ЖЕЛАТЕЛЬНО ЭТА
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // 3. Кнопки тоже ограничиваем по ширине
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .widthIn(max = 400.dp), // Кнопки не разлетятся по краям на планшете
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = onPreviousClick) {
                Text(text = "Назад")
            }
            Button(onClick = onNextClick) {
                Text(text = "Вперед")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtspaceTheme {
        ArtSpaceApp()
    }
}