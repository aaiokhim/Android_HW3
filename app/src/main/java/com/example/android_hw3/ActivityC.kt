package com.example.android_hw3

import com.example.android_hw3.R
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.LinearLayout
import android.graphics.Color
import kotlin.random.Random
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.android_hw3.ui.theme.Android_HW3Theme

class ActivityC : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)

        val randomColor = generateColor()
        val layout = findViewById<LinearLayout>(R.id.root_layout_c)
        layout.setBackgroundColor(randomColor)

        val btnToA = findViewById<Button>(R.id.btn_to_a)

        btnToA.setOnClickListener {
            val intent = Intent(this, ActivityA::class.java)
            startActivity(intent)
        }
    }

    private fun generateColor(): Int {
        return Color.rgb(
            Random.nextInt(256),
            Random.nextInt(256),
            Random.nextInt(256)
        )
    }

}