package com.example.android_hw3

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

class ActivityB : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        val randomColor = generateColor()
        val layout = findViewById<LinearLayout>(R.id.root_layout_b)
        layout.setBackgroundColor(randomColor)

        val btnToC = findViewById<Button>(R.id.btn_to_c)

        btnToC.setOnClickListener {
            val intent = Intent(this, ActivityC::class.java)
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