package com.a27.liftlab.lift.presentation.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.a27.liftlab.lift.data.dto.CreateDietRequest
import com.a27.liftlab.lift.domain.repository.DietRepository
import com.a27.liftlab.lift.presentation.models.DietUi
import com.a27.liftlab.lift.presentation.models.toDietUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DietViewModel(private val repo: DietRepository) : ViewModel() {
    private val _diets = MutableStateFlow<List<DietUi>>(emptyList())
    val diets: StateFlow<List<DietUi>> = _diets

    private val _selectedDiet = MutableStateFlow<DietUi?>(null)
    val selectedDiet: StateFlow<DietUi?> = _selectedDiet

    fun loadDiets(username: String) {
        viewModelScope.launch {
            _diets.value = repo.loadDiets(username).map { it.toDietUi() }
        }
    }

    fun loadDiet(username: String, dietId: String) {
        viewModelScope.launch {
            _selectedDiet.value = repo.loadDiet(username, dietId).toDietUi()
        }
    }

    fun createDiet(request: CreateDietRequest, onSuccess: (String) -> Unit) {
        viewModelScope.launch {
            val newId = repo.createDiet(request)
            onSuccess(newId)
        }
    }
}