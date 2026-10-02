package com.example.laba2

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val preferences = getSharedPreferences("user_data", MODE_PRIVATE)

        val name = preferences.getString("name", "")
        val email = preferences.getString("email", "")
        val login = preferences.getString("login", "")

        findViewById<TextView>(R.id.textProfileName).text =
            getString(R.string.profile_name, name)

        findViewById<TextView>(R.id.textProfileEmail).text =
            getString(R.string.profile_email, email)

        findViewById<TextView>(R.id.textProfileLogin).text =
            getString(R.string.profile_login, login)

        onBackPressedDispatcher.addCallback(
            this,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    Toast.makeText(
                        this@ProfileActivity,
                        "Вы вышли с окна Профиль",
                        Toast.LENGTH_SHORT
                    ).show()

                    finish()
                }
            }
        )
    }
}