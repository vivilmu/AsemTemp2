package com.example.asemtemp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.asemtemp2.model.Child

class ChildProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.child_profile)

        // Ambil data anak dari Intent
        val child = intent.getParcelableExtra<Child>("childData")

        // Tampilkan data anak di tampilan
        val textViewChildName = findViewById<TextView>(R.id.textViewChildName)
        val textViewChildAge = findViewById<TextView>(R.id.textViewChildAge)
        val textViewChildGender = findViewById<TextView>(R.id.textViewChildGender)

        if (child != null) {
            textViewChildName.text = "Nama: ${child.name}"
            textViewChildAge.text = "Umur: ${child.age}"
            textViewChildGender.text = "Jenis Kelamin: ${child.gender}"
        }
    }
}
