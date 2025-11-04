package com.example.android_hw3

import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.LinearLayout
import android.graphics.Color
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import kotlin.random.Random
import android.widget.EditText
import android.widget.TextView
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.android_hw3.ui.theme.Android_HW3Theme

class ActivityA : ComponentActivity() {

    //private val viewModel: ActivityAViewModel by viewModels()
    private val KEY_COLOR_FOR_A = "color_for_a"
    private val KEY_COLOR_FOR_B = "color_for_b"
    private var colorForA = Color.WHITE
    private var colorForB = Color.WHITE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        val layout = findViewById<LinearLayout>(R.id.root_layout_a)
        val colorShow = findViewById<TextView>(R.id.show_color)
        val btnGenerate = findViewById<Button>(R.id.btn_generate_color)
        val btnToB = findViewById<Button>(R.id.btn_to_b)

        if (savedInstanceState != null) {
            colorForA = savedInstanceState.getInt(KEY_COLOR_FOR_A, Color.WHITE)
            colorForB = savedInstanceState.getInt(KEY_COLOR_FOR_B, Color.WHITE)
            colorShow.setBackgroundColor(colorForB)
        } else {
            colorForA = generateColor()
        }

        layout.setBackgroundColor(colorForA)

        btnGenerate.setOnClickListener {
            colorForB = generateColor()
            colorShow.setBackgroundColor(colorForB)
        }

        btnToB.setOnClickListener {
            val intent = Intent(this, ActivityB::class.java)
            intent.putExtra("BACKGROUND_COLOR", colorForB)
            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) { //не очень поняла с outPersistentState: PersistableBundle, когда работает и как использовать
        super.onSaveInstanceState(outState) // так до конца и не поняла зачем оно нужно
        outState.putInt(KEY_COLOR_FOR_A, colorForA)
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