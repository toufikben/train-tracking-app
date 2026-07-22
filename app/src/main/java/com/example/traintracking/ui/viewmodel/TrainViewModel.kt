package com.example.traintracking.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.traintracking.data.model.Train
import com.example.traintracking.data.repository.TrainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrainViewModel @Inject constructor(
    private val repository: TrainRepository
) : ViewModel() {

    private val _trains = MutableStateFlow<List<Train>>(emptyList())
    val trains: StateFlow<List<Train>> = _trains

    init {
        loadTrains()
    }

    private fun loadTrains() {
        viewModelScope.launch {
            repository.getAllTrains().collect { trainList ->
                _trains.value = trainList
            }
        }
    }

    fun addTrain(train: Train) {
        viewModelScope.launch {
            repository.addTrain(train)
        }
    }

    fun deleteTrain(trainId: String) {
        viewModelScope.launch {
            repository.deleteTrain(trainId)
        }
    }

    fun updateTrain(train: Train) {
        viewModelScope.launch {
            repository.updateTrain(train)
        }
    }
}