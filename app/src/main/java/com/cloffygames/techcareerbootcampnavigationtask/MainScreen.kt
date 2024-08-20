package com.cloffygames.techcareerbootcampnavigationtask

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.cloffygames.techcareerbootcampnavigationtask.navigation_native.NativePageA
import com.cloffygames.techcareerbootcampnavigationtask.navigation_native.NativePageB
import com.cloffygames.techcareerbootcampnavigationtask.navigation_native.NativePageX
import com.cloffygames.techcareerbootcampnavigationtask.navigation_native.NativePageY
import com.cloffygames.techcareerbootcampnavigationtask.navigation_voyager.VoyagerPageA
import com.cloffygames.techcareerbootcampnavigationtask.navigation_voyager.VoyagerPageX

class MainScreen : Screen {
    @Composable
    override fun Content() {
        val isSwitchOn = remember { mutableStateOf(false) }

        val navigator = LocalNavigator.currentOrThrow

        // Başta MainActivity içinde MainScreen(navController) şeklinde çağırmayı denedim olmayınca bu yöntemi buldum.
        val navController = rememberNavController()

        Scaffold(        ) { paddingValues ->

            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .background(Color.Blue),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Main Screen")

                // Switch bileşeni: Kullanıcı Voyager veya Native navigasyonu arasında seçim yapar
                Switch(
                    checked = isSwitchOn.value,
                    onCheckedChange = { isChecked ->
                        isSwitchOn.value = isChecked // Switch durumu güncellenir
                    }
                )


                Button(onClick = {
                    if (isSwitchOn.value) {
                        // Switch açık ise Voyager navigasyonunu kullan
                        navigator.push(VoyagerPageA())
                    } else {
                        // Switch kapalı ise Native navigasyonunu kullan
                        navController.navigate("native_page_a")
                    }
                }) {
                    Text(text = "Go to Page A")
                }


                Button(onClick = {
                    if (isSwitchOn.value) {
                        // Switch açık ise Voyager navigasyonunu kullan
                        navigator.push(VoyagerPageX())
                    } else {
                        // Switch kapalı ise Native navigasyonunu kullan
                        navController.navigate("native_page_x")
                    }
                }) {
                    Text(text = "Go to Page X")
                }
            }

            // Native navigasyon için NavHost tanımlaması
            NavHost(navController = navController, startDestination = "main_screen") {


                composable("main_screen") {
                    MainScreen()
                }

                composable("native_page_a") {
                    NativePageA(navController = navController)
                }

                composable("native_page_b") {
                    NativePageB(navController = navController)
                }

                composable("native_page_x") {
                    NativePageX(navController = navController)
                }

                composable("native_page_y") {
                    NativePageY(navController = navController)
                }
            }
        }
    }
}
