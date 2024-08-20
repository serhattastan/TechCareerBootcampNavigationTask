package com.cloffygames.techcareerbootcampnavigationtask.navigation_voyager

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

class VoyagerPageX : Screen {
    @Composable
    override fun Content() {
        Scaffold(
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->

            val navigator = LocalNavigator.currentOrThrow

            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .background(Color.Gray),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(text = "Voyager Page X")

                Button(
                    onClick = {
                        navigator.push(VoyagerPageY())
                    },
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    Text(text = "Go to Page Y")
                }
            }
        }
    }

}