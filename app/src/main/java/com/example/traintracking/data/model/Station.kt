package com.example.traintracking.data.model

data class Station(
    val id: String,
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val code: String
)

val FIXED_STATIONS = listOf(
    Station(
        id = "1",
        name = "Central Station",
        latitude = 48.8566,
        longitude = 2.3522,
        code = "CS"
    ),
    Station(
        id = "2",
        name = "West Terminal",
        latitude = 48.8353,
        longitude = 2.2795,
        code = "WT"
    ),
    Station(
        id = "3",
        name = "North Junction",
        latitude = 48.8724,
        longitude = 2.3486,
        code = "NJ"
    ),
    Station(
        id = "4",
        name = "East Plaza",
        latitude = 48.8529,
        longitude = 2.3957,
        code = "EP"
    ),
    Station(
        id = "5",
        name = "South Express",
        latitude = 48.8387,
        longitude = 2.3391,
        code = "SE"
    )
)