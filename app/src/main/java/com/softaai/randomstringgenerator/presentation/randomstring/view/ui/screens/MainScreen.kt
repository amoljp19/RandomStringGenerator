package com.softaai.randomstringgenerator.presentation.randomstring.view.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.softaai.randomstringgenerator.presentation.randomstring.view.ui.theme.RandomStringGeneratorTheme
import com.softaai.randomstringgenerator.presentation.randomstring.viewmodel.MainViewModel


/**
 * Created by amoljp19 on 12/20/2024.
 * softAai Apps.
 */

@Composable
fun MainScreen() {
    MainView()
}

@Composable
private fun MainView(viewModel: MainViewModel = hiltViewModel()) {
    val state = viewModel.state.value
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Random String Generator",
            modifier = Modifier.padding(top = 15.dp, bottom = 10.dp)
        )

        var text by remember { mutableStateOf("0") }

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Enter random string length") }
        )

        Button(
            onClick = { viewModel.generateRandomString(text.toInt()) },
            modifier = Modifier
                .padding(16.dp), // Optional padding
            colors = ButtonDefaults.textButtonColors(
                containerColor = Color.DarkGray,
                contentColor = Color.White,
                disabledContentColor = Color.LightGray
            )
        ) {
            Text(text = "Generate Random String")
        }
        // Display the newly generated random string
        Text(text = state.randomString, fontSize = 12.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun MainViewPreview() {
    RandomStringGeneratorTheme {
        //MainView()
    }
}