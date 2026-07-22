package com.example.traintracking.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.traintracking.data.model.Train
import com.example.traintracking.ui.viewmodel.TrainViewModel
import java.util.UUID

@Composable
fun AddTrainScreen(
    onBackClick: () -> Unit,
    viewModel: TrainViewModel = hiltViewModel()
) {
    var trainName by remember { mutableStateOf("") }
    var trainNumber by remember { mutableStateOf("") }
    var latitude by remember { mutableStateOf("") }
    var longitude by remember { mutableStateOf("") }
    var selectedStatus by remember { mutableStateOf("On Time") }
    var selectedFromStation by remember { mutableStateOf("Central Station") }
    var selectedToStation by remember { mutableStateOf("West Terminal") }

    val stations = listOf(
        "Central Station",
        "West Terminal",
        "North Junction",
        "East Plaza",
        "South Express"
    )

    val statuses = listOf("On Time", "Delayed", "Arrived")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Add New Train") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedTextField(
                value = trainName,
                onValueChange = { trainName = it },
                label = { Text("Train Name") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = trainNumber,
                onValueChange = { trainNumber = it },
                label = { Text("Train Number") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = latitude,
                onValueChange = { latitude = it },
                label = { Text("Latitude") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = longitude,
                onValueChange = { longitude = it },
                label = { Text("Longitude") },
                modifier = Modifier.fillMaxWidth()
            )

            // From Station dropdown
            var expandedFrom by remember { mutableStateOf(false) }
            ExposedDropdownMenuBox(
                expanded = expandedFrom,
                onExpandedChange = { expandedFrom = it }
            ) {
                OutlinedTextField(
                    value = selectedFromStation,
                    onValueChange = {},
                    label = { Text("From Station") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor(),
                    readOnly = true
                )
                ExposedDropdownMenu(
                    expanded = expandedFrom,
                    onDismissRequest = { expandedFrom = false }
                ) {
                    stations.forEach { station ->
                        DropdownMenuItem(
                            text = { Text(station) },
                            onClick = {
                                selectedFromStation = station
                                expandedFrom = false
                            }
                        )
                    }
                }
            }

            // To Station dropdown
            var expandedTo by remember { mutableStateOf(false) }
            ExposedDropdownMenuBox(
                expanded = expandedTo,
                onExpandedChange = { expandedTo = it }
            ) {
                OutlinedTextField(
                    value = selectedToStation,
                    onValueChange = {},
                    label = { Text("To Station") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor(),
                    readOnly = true
                )
                ExposedDropdownMenu(
                    expanded = expandedTo,
                    onDismissRequest = { expandedTo = false }
                ) {
                    stations.forEach { station ->
                        DropdownMenuItem(
                            text = { Text(station) },
                            onClick = {
                                selectedToStation = station
                                expandedTo = false
                            }
                        )
                    }
                }
            }

            // Status dropdown
            var expandedStatus by remember { mutableStateOf(false) }
            ExposedDropdownMenuBox(
                expanded = expandedStatus,
                onExpandedChange = { expandedStatus = it }
            ) {
                OutlinedTextField(
                    value = selectedStatus,
                    onValueChange = {},
                    label = { Text("Status") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .menuAnchor(),
                    readOnly = true
                )
                ExposedDropdownMenu(
                    expanded = expandedStatus,
                    onDismissRequest = { expandedStatus = false }
                ) {
                    statuses.forEach { status ->
                        DropdownMenuItem(
                            text = { Text(status) },
                            onClick = {
                                selectedStatus = status
                                expandedStatus = false
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    if (trainName.isNotEmpty() && trainNumber.isNotEmpty() &&
                        latitude.isNotEmpty() && longitude.isNotEmpty()
                    ) {
                        val newTrain = Train(
                            id = UUID.randomUUID().toString(),
                            name = trainName,
                            number = trainNumber,
                            latitude = latitude.toDouble(),
                            longitude = longitude.toDouble(),
                            station = selectedFromStation,
                            destination = selectedToStation,
                            status = selectedStatus,
                            lastUpdated = System.currentTimeMillis()
                        )
                        viewModel.addTrain(newTrain)
                        onBackClick()
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Text("Save Train")
            }
        }
    }
}