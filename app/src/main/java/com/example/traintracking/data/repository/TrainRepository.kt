package com.example.traintracking.data.repository

import com.example.traintracking.data.model.Train
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow

class TrainRepository {

    private val trainsFlow = MutableStateFlow<List<Train>>(emptyList())

    fun getAllTrains(): Flow<List<Train>> = trainsFlow

    suspend fun addTrain(train: Train) {
        val currentTrains = trainsFlow.value.toMutableList()
        currentTrains.add(train)
        trainsFlow.emit(currentTrains)
    }

    suspend fun deleteTrain(trainId: String) {
        val currentTrains = trainsFlow.value.toMutableList()
        currentTrains.removeAll { it.id == trainId }
        trainsFlow.emit(currentTrains)
    }

    suspend fun updateTrain(train: Train) {
        val currentTrains = trainsFlow.value.toMutableList()
        val index = currentTrains.indexOfFirst { it.id == train.id }
        if (index >= 0) {
            currentTrains[index] = train
            trainsFlow.emit(currentTrains)
        }
    }

    suspend fun getTrainById(trainId: String): Train? {
        return trainsFlow.value.find { it.id == trainId }
    }
}