package com.example.traintracking.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.traintracking.data.model.Train
import com.example.traintracking.ui.viewmodel.TrainViewModel

@Composable
fun HomeScreen(
    onTrainClick: (Train) -> Unit,
    onAddTrainClick: () -> Unit,
    viewModel: TrainViewModel = hiltViewModel()
) {
    val trains = viewModel.trains.collectAsState().value

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Train Tracking") }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAddTrainClick,
                modifier = Modifier.padding(16.dp)
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add Train")
            }
        }
    ) { paddingValues ->
        if (trains.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "No trains available. Click the button to add one.",
                    fontSize = 16.sp
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(horizontal = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(vertical = 8.dp)
            ) {
                items(trains) { train ->
                    TrainCard(
                        train = train,
                        onClick = { onTrainClick(train) }
                    )
                }
            }
        }
    }
}

@Composable
fun TrainCard(
    train: Train,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = train.name,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Train #${train.number}",
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
                Column(modifier = Modifier.weight(1f)) {
                    Text("From", fontSize = 12.sp)
                    Text(train.station, fontSize = 14.sp)
                }
                Column(modifier = Modifier.weight(1f)) {
                    Text("To", fontSize = 12.sp)
                    Text(train.destination, fontSize = 14.sp)
                }
            }
        }
    }
}

@Composable
fun StatusBadge(status: String) {
    val backgroundColor = when (status) {
        "On Time" -> MaterialTheme.colorScheme.primary
        "Delayed" -> Color(0xFFFFC107)
        "Arrived" -> Color(0xFF4CAF50)
        else -> MaterialTheme.colorScheme.surface
    }

    Surface(
        modifier = Modifier.padding(4.dp),
        shape = RoundedCornerShape(8.dp),
        color = backgroundColor
    ) {
        Text(
            text = status,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
            color = Color.White,
            fontSize = 12.sp
        )
    }
}