package com.cloffygames.techcareerbootcampnavigationtask.navigation_voyager

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.cloffygames.techcareerbootcampnavigationtask.MainScreen

class VoyagerPageY : Screen {
    @Composable
    override fun Content() {
        Scaffold(
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->

            val navigator = LocalNavigator.currentOrThrow

            BackHandler {
                navigator.push(MainScreen())
            }

            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .background(Color.Yellow),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(text = "Voyager Page Y")

                Button(
                    onClick = {
                        navigator.push(MainScreen())
                    },
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    Text(text = "Go to Main Screen")
                }
            }
        }
    }
}
