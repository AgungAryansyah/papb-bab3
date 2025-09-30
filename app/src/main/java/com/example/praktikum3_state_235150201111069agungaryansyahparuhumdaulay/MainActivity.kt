package com.example.praktikum3_state_235150201111069agungaryansyahparuhumdaulay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()), // biar bisa discroll kalau kepanjangan
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CounterApp()

        Spacer(modifier = Modifier.height(24.dp))

        ColorToggleBox()

        Spacer(modifier = Modifier.height(24.dp))

        ProfileCard()
    }
}

@Composable
fun CounterApp() {
    var count by remember { mutableStateOf(0) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Text("Jumlah: $count", fontSize = 24.sp)

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            Button(onClick = { if (count > 0) count-- }) {
                Text("Kurang (–)")
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(onClick = { count++ }) {
                Text("Tambah (+)")
            }
        }
    }
}

@Composable
fun ColorToggleBox() {
    var isRed by remember { mutableStateOf(true) }

    Box(
        modifier = Modifier
            .size(200.dp)
            .background(if (isRed) Color.Red else Color.Green)
            .clickable { isRed = !isRed }
    )
}

@Composable
fun ProfileCard() {
    var isFollowed by remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Image(
        painter = painterResource(R.drawable.ic_launcher_foreground),
        contentDescription = "Foto Profil",
        modifier = Modifier.size(120.dp).clip(CircleShape)
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text("Nama: Agung", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(4.dp))
        Text("Mahasiswa Teknik Informatika")

        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = { isFollowed = !isFollowed }) {
            Text(if (isFollowed) "Unfollow" else "Follow")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            if (isFollowed) "Anda mengikuti akun ini"
            else "Anda belum mengikuti akun ini"
        )
    }
}
