package com.example.asemtemp2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonGoToRegistration = findViewById<Button>(R.id.buttonGoToRegistration)

        // Tombol untuk pergi ke halaman registrasi
        buttonGoToRegistration.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }

        // Saat login berhasil, simpan status login
//        val sharedPref = getSharedPreferences("login_status", Context.MODE_PRIVATE)
//        val editor = sharedPref.edit()
//        editor.putBoolean("isLoggedIn", true)
//        editor.apply()
//
//        // Pemeriksaan status login di MainActivity
//        val isLoggedIn = sharedPref.getBoolean("isLoggedIn", false)
//
//        if (isLoggedIn) {
//            // Pengguna sudah login, arahkan ke halaman beranda
//            val intent = Intent(this, HomePageActivity::class.java)
//            startActivity(intent)
//        } else {
//            // Pengguna belum login, arahkan ke halaman login
//            val intent = Intent(this, LoginActivity::class.java)
//            startActivity(intent)
//        }


        // Implementasikan navigasi atau inisialisasi lainnya sesuai kebutuhan Anda
    }
}
