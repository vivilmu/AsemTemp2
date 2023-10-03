package com.example.asemtemp2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class RegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        val buttonRegister = findViewById<Button>(R.id.buttonRegister)


        buttonRegister.setOnClickListener {
            val username = findViewById<EditText>(R.id.editTextUsername).text.toString()
            val password = findViewById<EditText>(R.id.editTextPassword).text.toString()

            if (isUsernameValid(username) && isPasswordValid(password)) {
                // Simpan informasi pengguna ke penyimpanan data
                saveUserData(username, password)

                // Navigasi ke halaman beranda atau lainnya
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            } else {
                // Tampilkan pesan kesalahan
                showToast("Username atau password tidak valid")
            }
        }
    }

    private fun isUsernameValid(username: String): Boolean {
        // Validasi username di sini, Anda dapat menyesuaikan
        return username.isNotEmpty()
    }

    private fun isPasswordValid(password: String): Boolean {
        // Validasi password di sini, Anda dapat menyesuaikan
        return password.length == 6
    }

    private fun saveUserData(username: String, password: String) {
        val sharedPref = getSharedPreferences("user_data", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("username", username)
        editor.putString("password", password)
        editor.apply()
    }


    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}