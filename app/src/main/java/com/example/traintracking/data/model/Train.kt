package com.example.traintracking.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Train(
    val id: String,
    val name: String,
    val number: String,
    val latitude: Double,
    val longitude: Double,
    val station: String,
    val destination: String,
    val status: String,
    val lastUpdated: Long
)