package com.example.laba2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var editName: EditText
    private lateinit var editEmail: EditText
    private lateinit var editLogin: EditText
    private lateinit var editPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        editName = findViewById(R.id.editName)
        editEmail = findViewById(R.id.editEmail)
        editLogin = findViewById(R.id.editRegisterLogin)
        editPassword = findViewById(R.id.editRegisterPassword)

        if (savedInstanceState != null) {
            editName.setText(savedInstanceState.getString("name"))
            editEmail.setText(savedInstanceState.getString("email"))
            editLogin.setText(savedInstanceState.getString("login"))
            editPassword.setText(savedInstanceState.getString("password"))
        }

        findViewById<Button>(R.id.buttonRegisterSubmit).setOnClickListener {
            val preferences = getSharedPreferences("user_data", MODE_PRIVATE)

            preferences.edit()
                .putString("name", editName.text.toString())
                .putString("email", editEmail.text.toString())
                .putString("login", editLogin.text.toString())
                .apply()

            finish()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("name", editName.text.toString())
        outState.putString("email", editEmail.text.toString())
        outState.putString("login", editLogin.text.toString())
        outState.putString("password", editPassword.text.toString())

        super.onSaveInstanceState(outState)
    }
}