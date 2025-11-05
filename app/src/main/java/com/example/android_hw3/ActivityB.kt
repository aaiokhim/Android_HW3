package com.example.android_hw3

import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.LinearLayout
import android.graphics.Color
import kotlin.random.Random
import androidx.activity.viewModels
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

    //private val viewModel: ActivityBViewModel by viewModels()
    private val KEY_COLOR_FOR_B = "color_for_b"
    private var colorForB = Color.WHITE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        val layout = findViewById<LinearLayout>(R.id.root_layout_b)
        val btnToC = findViewById<Button>(R.id.btn_to_c)

        if (savedInstanceState != null) {
            colorForB = savedInstanceState.getInt(KEY_COLOR_FOR_B, Color.WHITE)
            //layout.setBackgroundColor(colorForB)
        } else {
            colorForB = intent.getIntExtra("BACKGROUND_COLOR", Color.WHITE)
        }

        layout.setBackgroundColor(colorForB)

        btnToC.setOnClickListener {
            val intent = Intent(this, ActivityC::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_COLOR_FOR_B, colorForB)
    }

    private fun generateColor(): Int {
        return Color.rgb(
            Random.nextInt(256),
            Random.nextInt(256),
            Random.nextInt(256)
        )
    }

}