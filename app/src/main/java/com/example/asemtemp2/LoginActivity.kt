package com.example.asemtemp2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val editTextUsername = findViewById<EditText>(R.id.editTextUsername)
        val editTextPassword = findViewById<EditText>(R.id.editTextPassword)
        val buttonLogin = findViewById<Button>(R.id.buttonLogin)

        // Tombol untuk melakukan login
        buttonLogin.setOnClickListener {
            val username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()

            // Mendapatkan data registrasi pengguna yang tersimpan
            val sharedPref = getSharedPreferences("user_data", Context.MODE_PRIVATE)
            val registeredUsername = sharedPref.getString("username", "")
            val registeredPassword = sharedPref.getString("password", "")

            // Memeriksa apakah username dan password sesuai dengan data registrasi
            if (isLoginValid(username, password, registeredUsername, registeredPassword)) {
                // Saat login berhasil, simpan status login
                val editor = sharedPref.edit()
                editor.putBoolean("isLoggedIn", true)
                editor.apply()

                // Arahkan pengguna ke halaman beranda
                val intent = Intent(this, HomePageActivity::class.java)
                startActivity(intent)
                finish()
            }
            else {
                // Jika login gagal, tampilkan pesan kesalahan
                showToast("Username atau password salah")
            }
        }
    }

    // Fungsi untuk memeriksa validitas login sesuai dengan data registrasi
    private fun isLoginValid(
        username: String,
        password: String,
        registeredUsername: String?,
        registeredPassword: String?
    ): Boolean {
        // Anda dapat mengganti ini dengan logika validasi sesuai dengan kebutuhan Anda
        return username == registeredUsername && password == registeredPassword
    }

    // Fungsi untuk menampilkan pesan toast
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
