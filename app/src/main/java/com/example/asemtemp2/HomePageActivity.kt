package com.example.asemtemp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton


class HomePageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        // Menampilkan profil anak-anak yang dapat dipilih
        val childProfiles = listOf("Jhon", "Thor") // Ganti dengan data profil anak-anak Anda
        val buttonMandi = findViewById<Button>(R.id.buttonMandi)
        val buttonMakan = findViewById<Button>(R.id.buttonMakan)
        val buttonTidur = findViewById<Button>(R.id.buttonTidur)
        val buttonBeliBaju = findViewById<Button>(R.id.buttonBeliBaju)
        val buttonGantiBaju = findViewById<Button>(R.id.buttonGantiBaju)
        // Implementasikan tampilan profil anak-anak (misalnya, menggunakan RecyclerView)
        // Di sini, Anda dapat menggunakan RecyclerViewAdapter untuk menampilkan daftar profil anak-anak
        val backButton = findViewById<ImageButton>(R.id.buttonBackToParent)
        val shopButton = findViewById<ImageButton>(R.id.shopButton)

        shopButton.setOnClickListener {
            val intent = Intent(this, ShopActivity::class.java)
            startActivity(intent)
        }

        backButton.setOnClickListener {
            val intent = Intent(this, ParentPageActivity::class.java)
            startActivity(intent)
        }

        // Tombol aksi
        buttonMandi.setOnClickListener {
            // Logika untuk mandi
        }

        buttonMakan.setOnClickListener {
            // Logika untuk makan
        }

        buttonTidur.setOnClickListener {
            // Logika untuk tidur
        }

        buttonBeliBaju.setOnClickListener {
            // Logika untuk beli baju
        }

        buttonGantiBaju.setOnClickListener {
            // Logika untuk ganti baju
        }

        // Implementasikan logika lainnya sesuai kebutuhan
    }
}
