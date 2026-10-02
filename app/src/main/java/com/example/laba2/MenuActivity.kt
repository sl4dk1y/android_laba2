package com.example.laba2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        findViewById<Button>(R.id.buttonProfile).setOnClickListener {
            val openIntent = Intent(this, ProfileActivity::class.java)
            startActivity(openIntent)
        }

        findViewById<Button>(R.id.buttonSettings).setOnClickListener {
            val openIntent = Intent(this, SettingsActivity::class.java)
            startActivity(openIntent)
        }

        findViewById<Button>(R.id.buttonReport).setOnClickListener {
            val sendIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(
                    Intent.EXTRA_SUBJECT,
                    getString(R.string.problem_subject)
                )
                putExtra(
                    Intent.EXTRA_TEXT,
                    getString(R.string.problem_text)
                )
            }

            startActivity(
                Intent.createChooser(
                    sendIntent,
                    getString(R.string.share_problem)
                )
            )
        }

        findViewById<Button>(R.id.buttonExit).setOnClickListener {
            finishAffinity()
        }

        onBackPressedDispatcher.addCallback(
            this,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    Toast.makeText(
                        this@MenuActivity,
                        "Вы вышли с окна Меню",
                        Toast.LENGTH_SHORT
                    ).show()

                    finish()
                }
            }
        )
    }
}