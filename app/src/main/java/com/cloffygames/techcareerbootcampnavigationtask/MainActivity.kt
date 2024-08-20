package com.cloffygames.techcareerbootcampnavigationtask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.cloffygames.techcareerbootcampnavigationtask.ui.theme.TechCareerBootcampNavigationTaskTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TechCareerBootcampNavigationTaskTheme {
                Navigator(screen = MainScreen()) //Başta MainScreen(navController) şeklinde çağırmayı denedim olmayınca bu yöntemi buldum.
            }
        }
    }
}
