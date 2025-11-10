package com.example.android_hw3

import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.LinearLayout
import android.graphics.Color
import androidx.activity.ComponentActivity
import kotlin.random.Random
import android.widget.EditText
import android.widget.TextView
import android.util.Log

class ActivityA : ComponentActivity() {
    private var colorForA = Color.WHITE
    private var colorForB = Color.WHITE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        val layout = findViewById<LinearLayout>(R.id.root_layout_a)
        val colorShow = findViewById<TextView>(R.id.show_color)
        val btnGenerate = findViewById<Button>(R.id.btn_generate_color)
        val btnToB = findViewById<Button>(R.id.btn_to_b)
        val colorInput = findViewById<EditText>(R.id.color_input)

        if (savedInstanceState != null) {
            colorForA = savedInstanceState.getInt(Constants.KEY_COLOR_FOR_A, Color.WHITE)
            colorForB = savedInstanceState.getInt(Constants.KEY_COLOR_FOR_B, Color.WHITE)
            colorShow.setBackgroundColor(colorForB)
        } else {
            colorForA = generateColor()
        }

        layout.setBackgroundColor(colorForA)

        btnGenerate.setOnClickListener {
            val userInput = colorInput.text.toString().trim()
            val check = checkColor(userInput)
            if (userInput.isEmpty()) {
                colorForB = generateColor()
                colorShow.setBackgroundColor(colorForB)
                colorShow.text = "Show color"
            } else if (check == false) {
                //смена текста в поле показа цвета
                colorShow.text = "Input error"
                colorInput.text.clear()
            } else {
                colorForB = Color.parseColor(userInput)
                colorShow.setBackgroundColor(colorForB)
                colorShow.text = "Show color"
                colorInput.text.clear()
            }
        }

        btnToB.setOnClickListener {
            val intent = Intent(this, ActivityB::class.java)
            intent.putExtra("BACKGROUND_COLOR", colorForB)

            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_MULTIPLE_TASK

            startActivity(intent)
        }
    }

    override fun onNewIntent(intent: Intent) { //Насколько я понимаю переопределение этой функции не обязательно, поскольку ActivityA не принимает никаких данных из вне
        super.onNewIntent(intent)
        Log.d("ActivityA", "onNewIntent called")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(Constants.KEY_COLOR_FOR_A, colorForA)
        outState.putInt(Constants.KEY_COLOR_FOR_B, colorForB)
    }

    private fun generateColor(): Int {
        return Color.rgb(
            Random.nextInt(256),
            Random.nextInt(256),
            Random.nextInt(256)
        )
    }

    private fun checkColor(color: String): Boolean {
        val hexColor = Regex("^#([A-Fa-f0-9]{6})\$")
        return color.matches(hexColor)
    }

}