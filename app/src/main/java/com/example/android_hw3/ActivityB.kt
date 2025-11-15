package com.example.android_hw3

import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.LinearLayout
import android.graphics.Color
import kotlin.random.Random
import androidx.activity.ComponentActivity

class ActivityB : ComponentActivity() {
    private var colorForB = Color.WHITE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        val layout = findViewById<LinearLayout>(R.id.root_layout_b)
        val btnToC = findViewById<Button>(R.id.btn_to_c)

        if (savedInstanceState != null) {
            colorForB = savedInstanceState.getInt(Constants.KEY_COLOR_FOR_B, Color.WHITE)
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
        outState.putInt(Constants.KEY_COLOR_FOR_B, colorForB)
    }

    private fun generateColor(): Int {
        return Color.rgb(
            Random.nextInt(256),
            Random.nextInt(256),
            Random.nextInt(256)
        )
    }

}