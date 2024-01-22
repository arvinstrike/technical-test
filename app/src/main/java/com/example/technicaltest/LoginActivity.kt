package com.example.technicaltest

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var editTextUsername: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonLogin: Button
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        editTextUsername = findViewById(R.id.username_login)
        editTextPassword = findViewById(R.id.password_login)
        buttonLogin = findViewById(R.id.login_btn)
        progressBar = findViewById(R.id.progressBar)

        buttonLogin.setOnClickListener {
            val enteredUsername = editTextUsername.text.toString()
            val enteredPassword = editTextPassword.text.toString()

            if (validateInput(enteredUsername, enteredPassword)) {
                // ini untuk loading/progress bar
                progressBar.visibility = View.VISIBLE
                loginSimulator(enteredUsername, enteredPassword)
            }
        }
    }
    // validateInput untuk memastikan input tidak null
    private fun validateInput(username: String, password: String): Boolean {
        if (username.isBlank() || password.isBlank()) {
            Toast.makeText(this, "Username and password cannot be empty", Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }

    private fun loginSimulator(username: String, password: String) {

        if (username == "alfagift-admin" && password == "asdf") {
            // jika username dan password sesuai, lanjutkan ke mainactivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            // jika terdapat kesalahan, akan muncul text message dan login gagal
            progressBar.visibility = View.GONE
            Toast.makeText(this, "Incorrect username or password", Toast.LENGTH_LONG).show()
        }
    }
}
