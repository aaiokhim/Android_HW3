package com.example.android_hw3

import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.LinearLayout
import android.graphics.Color
import androidx.activity.ComponentActivity
import kotlin.random.Random
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

class ActivityA : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        val randomColor = generateColor()
        val layout = findViewById<LinearLayout>(R.id.root_layout_a)
        layout.setBackgroundColor(randomColor)

        val btnToB = findViewById<Button>(R.id.btn_to_b)
        btnToB.setOnClickListener {
            val intent = Intent(this, ActivityB::class.java)
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