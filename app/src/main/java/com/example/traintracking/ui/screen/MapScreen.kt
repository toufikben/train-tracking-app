package com.example.traintracking.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.traintracking.data.model.Train
import com.example.traintracking.ui.viewmodel.LocationViewModel

@Composable
fun MapScreen(
    train: Train,
    onBackClick: () -> Unit,
    viewModel: LocationViewModel = hiltViewModel()
) {
    val userLocation = viewModel.userLocation.collectAsState().value

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(train.name) },
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
                .background(Color.LightGray)
        ) {
            // Map placeholder
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(Color(0xFFE0E0E0)),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Google Maps Integration",
                    fontSize = 18.sp,
                    color = Color.Gray
                )
            }

            // Train info card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text(
                        text = train.name,
                        fontSize = 18.sp,
                        style = MaterialTheme.typography.headlineSmall
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text("Current Location", fontSize = 12.sp)
                            Text(
                                text = "Lat: ${String.format("%.4f", train.latitude)}",
                                fontSize = 14.sp
                            )
                            Text(
                                text = "Lon: ${String.format("%.4f", train.longitude)}",
                                fontSize = 14.sp
                            )
                        }
                        StatusBadge(status = train.status)
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text("From", fontSize = 12.sp)
                            Text(train.station, fontSize = 14.sp)
                        }
                        Column {
                            Text("To", fontSize = 12.sp)
                            Text(train.destination, fontSize = 14.sp)
                        }
                    }
                }
            }
        }
    }
}