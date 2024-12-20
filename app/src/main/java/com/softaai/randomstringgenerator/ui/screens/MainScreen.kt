package com.softaai.randomstringgenerator.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.SemanticsActions.OnClick
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.softaai.randomstringgenerator.domain.RandomGeneratedString
import com.softaai.randomstringgenerator.presentation.MainViewModel
import com.softaai.randomstringgenerator.presentation.OnClickGenerateRandomStringEvent


/**
 * Created by amoljp19 on 12/20/2024.
 * softAai Apps.
 */

@Composable
fun MainScreenContent(
    viewModel: MainViewModel = hiltViewModel(),
) {
    // Collect state from the ViewModel
    val state by viewModel.state.collectAsState()

    // Pass events to the ViewModel via listeners
    MainScreen(
        state = state,
        OnClickGenerateRandomString = { viewModel.onEvent(OnClickGenerateRandomStringEvent) }
    )

    RandomGeneratedString(state = state, OnClickGenerateRandomString)
}

@Composable
private fun MainScreen(
    state: MainScreenState,
    onClickGeneratedString: OnClickGenerateRandomStringEvent: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Random String Generato", modifier = Modifier.padding(bottom = 10.dp))
        // Trigger ViewModel event on button click
        Button(onClick = onClickGeneratedString,
            modifier = Modifier
                .padding(16.dp), // Optional padding
            colors = ButtonDefaults.textButtonColors(
                containerColor = Color.DarkGray,
                contentColor = Color.White,
                disabledContentColor = Color.LightGray
            )) {
            Text(text = "My Counter")
        }
        // Display the counter from the state
        Text(text = "+${state.counter}", fontSize = 40.sp)
    }
}