package com.softaai.randomstringgenerator.presentation.randomstring.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.softaai.randomstringgenerator.domain.GenerateRandomStringUseCase
import com.softaai.randomstringgenerator.domain.resource.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * Created by amoljp19 on 12/20/2024.
 * softAai Apps.
 */
@HiltViewModel
class MainViewModel @Inject constructor(private val generateRandomStringUseCase: GenerateRandomStringUseCase) :
    ViewModel() {


    private val _state = mutableStateOf(MainViewUIState())
    val state: State<MainViewUIState> = _state

    /*    private val _eventFlow = MutableSharedFlow<MainViewEvent>()
        val eventFlow = _eventFlow.asSharedFlow()*/


    // Process events sent from the view
    fun generateRandomString(length: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            generateRandomStringUseCase(length).onEach { result ->
                when (result) {
                    is Resource.Loading -> {
                        _state.value = state.value.copy(
                            randomString = result.data.toString(),
                            isLoading = true
                        )
                    }

                    is Resource.Success -> {
                        _state.value = state.value.copy(
                            randomString = result.data!!.randomString,
                            isLoading = false
                        )
                    }

                    is Resource.Error -> {
                        _state.value = state.value.copy(
                            randomString = result.data.toString(),
                            isLoading = false
                        )

                    }
                }
            }.launchIn(this)
        }
    }
}