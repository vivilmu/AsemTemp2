package com.example.asemtemp2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.asemtemp2.model.Child

class ParentPageActivity : AppCompatActivity() {

    private val children = mutableListOf<Child>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parent_page)

        val buttonTambahAnak = findViewById<Button>(R.id.buttonTambahAnak)
        val buttonPengaturanMandi = findViewById<Button>(R.id.buttonPengaturanMandi)
        val buttonPengaturanMakan = findViewById<Button>(R.id.buttonPengaturanMakan)
        val buttonPengaturanTidur = findViewById<Button>(R.id.buttonPengaturanTidur)

        buttonTambahAnak.setOnClickListener {
            val intent = Intent(this, TambahAnakActivity::class.java)
            startActivityForResult(intent, REQUEST_ADD_CHILD)
        }

        buttonPengaturanMandi.setOnClickListener {
            // Logika untuk pengaturan jam mandi
        }

        buttonPengaturanMakan.setOnClickListener {
            // Logika untuk pengaturan jam makan
        }

        buttonPengaturanTidur.setOnClickListener {
            // Logika untuk pengaturan jam tidur
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_ADD_CHILD && resultCode == RESULT_OK) {
            val childData = data?.getParcelableExtra<Child>("childData")

            // Menambahkan childData baru ke daftar children
            if (childData != null) {
                children.add(childData)

                // Tambahkan elemen tampilan TextView untuk menampilkan profil anak
                val linearLayout = findViewById<LinearLayout>(R.id.linearLayoutChildList)
                val childView = TextView(this)
                childView.text = "Nama: ${childData.name}, Umur: ${childData.age}, Gender: ${childData.gender}"

                // Tambahkan childView ke dalam LinearLayout
                linearLayout.addView(childView)
            }
        }
    }

    companion object {
        private const val REQUEST_ADD_CHILD = 1
    }
}
