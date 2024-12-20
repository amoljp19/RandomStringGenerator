package com.softaai.randomstringgenerator.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.softaai.randomstringgenerator.domain.GenerateRandomStringUseCase
import com.softaai.randomstringgenerator.domain.RandomGeneratedString
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * Created by amoljp19 on 12/20/2024.
 * softAai Apps.
 */
@HiltViewModel
class MainViewModel @Inject constructor(private val generateRandomStringUseCase: GenerateRandomStringUseCase): ViewModel() {

    // State is maintained using StateFlow
    private val _state = MutableStateFlow(RandomGeneratedString.initValue)
    val state: StateFlow<RandomGeneratedString> = _state.asStateFlow()



    // Function to get the current state
    private fun currentState(): RandomGeneratedString = _state.value

    // Function to update the state
    private fun updateState(newState: RandomGeneratedString) {
        _state.value = newState
    }

    // Process events sent from the view
    fun onEvent(event: MainViewEvent) {
        viewModelScope.launch {
            when (event) {
                is OnClickGenerateRandomStringEvent -> OnClickGenerateRandomStringEvent()
            }
        }
    }

    // Handle the OnClickCountUpEvent
    private suspend fun OnClickGenerateRandomStringEvent() {
        generateRandomStringUseCase.generateRandomString(length = 1)
        val newGeneratedRandomScreen = generateRandomStringUseCase.generateRandomString(length = 1)
        updateState(currentState().copy(randomString = newGeneratedRandomScreen.randomString))
    }
}