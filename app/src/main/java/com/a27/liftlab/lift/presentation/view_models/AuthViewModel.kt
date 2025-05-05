package com.a27.liftlab.lift.presentation.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.a27.liftlab.lift.domain.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthViewModel(
    private val repository: UserRepository
) : ViewModel() {

    private val _authStatus = MutableStateFlow<String?>(null)
    val authStatus: StateFlow<String?> = _authStatus

    fun register(user: String, password: String, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            val result = repository.register(user, password)
            _authStatus.value = result.getOrNull() ?: "Registration failed"
            onResult(result.isSuccess)
        }
    }

    fun login(user: String, password: String, onResult: (Boolean) -> Unit) {
        viewModelScope.launch {
            val result = repository.login(user, password)
            _authStatus.value = result.getOrNull() ?: "Login failed"
            onResult(result.isSuccess)
        }
    }
}