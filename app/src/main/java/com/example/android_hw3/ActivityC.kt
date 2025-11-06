package com.example.android_hw3

import com.example.android_hw3.R
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.LinearLayout
import android.graphics.Color
import kotlin.random.Random
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
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
    private var colorForC = Color.WHITE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)

        val layout = findViewById<LinearLayout>(R.id.root_layout_c)
        val btnToA = findViewById<Button>(R.id.btn_to_a)

        colorForC = savedInstanceState ?.let { it : Bundle ->
            it.getInt(Constants.KEY_COLOR_FOR_C, Color.WHITE)
        } ?: generateColor()

        layout.setBackgroundColor(colorForC)

        btnToA.setOnClickListener {
            val intent = Intent(this, ActivityA::class.java)

            intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT

            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(Constants.KEY_COLOR_FOR_C, colorForC)
    }

    private fun generateColor(): Int {
        return Color.rgb(
            Random.nextInt(256),
            Random.nextInt(256),
            Random.nextInt(256)
        )
    }

}