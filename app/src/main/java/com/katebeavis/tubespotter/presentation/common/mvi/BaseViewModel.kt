package com.katebeavis.tubespotter.presentation.common.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<S : UiState, A : UiAction, E : UiSideEffect>(
    initialState: S
) : ViewModel() {

    private val _uiState = MutableStateFlow(initialState)
    val uiState: StateFlow<S> = _uiState.asStateFlow()

    private val _sideEffect = Channel<E>()
    val sideEffect = _sideEffect.receiveAsFlow()

    fun postAction(action: A) {
        viewModelScope.launch {
            handleAction(action)
        }
    }

    protected abstract fun handleAction(action: A)

    protected fun updateState(block: S.() -> S) {
        _uiState.value = block(_uiState.value)
    }

    protected fun postSideEffect(effect: E) {
        viewModelScope.launch {
            _sideEffect.send(effect)
        }
    }
}