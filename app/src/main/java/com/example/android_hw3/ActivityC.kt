package com.example.android_hw3

import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.LinearLayout
import android.graphics.Color
import kotlin.random.Random
import androidx.activity.ComponentActivity
import android.app.ActivityManager
import android.os.Build
import android.util.Log

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
            finishAffinity()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(Constants.KEY_COLOR_FOR_C, colorForC)
    }

    override fun onResume() {
        super.onResume()
        printActivityStack()
    }

    private fun generateColor(): Int {
        return Color.rgb(
            Random.nextInt(256),
            Random.nextInt(256),
            Random.nextInt(256)
        )
    }

    fun printActivityStack(tag: String = "ActivityStack") {
        val activityManager = getSystemService(ACTIVITY_SERVICE) as ActivityManager

        Log.d(tag, "=== CURRENT APP TASKS ===")

        activityManager.appTasks.forEachIndexed { taskIndex, appTask ->
            val taskInfo = appTask.taskInfo

            if (taskInfo.id == -1) return

            Log.d(tag, "AppTask #$taskIndex")
            Log.d(tag, "\tTask ID: ${taskInfo.id}")
            Log.d(tag, "\tNumber of Activities: ${taskInfo.numActivities}")
            Log.d(tag, "\tBase Activity: ${taskInfo.baseActivity?.className}")
            Log.d(tag, "\tTop Activity: ${taskInfo.topActivity?.className}")

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                Log.d(tag, "\tisRunning: ${taskInfo.isRunning}")
            }
        }
    }

}