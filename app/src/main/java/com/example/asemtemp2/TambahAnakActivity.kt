package com.example.asemtemp2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioGroup
import com.example.asemtemp2.model.Child

class TambahAnakActivity : AppCompatActivity() {
    private lateinit var editTextName: EditText
    private lateinit var editTextAge: EditText
    private lateinit var radioGroupGender: RadioGroup
    private lateinit var imageViewAvatar: ImageView
    private lateinit var buttonSaveChild: Button
    private lateinit var buttonNextAvatar: Button
    private lateinit var buttonPrevAvatar: Button

    private var currentAvatarIndex = 0
    private val maleAvatars = listOf("cowo1", "cowo2", "cowo3")
    private val femaleAvatars = listOf("cewe1", "cewe2", "cewe3")
    private lateinit var selectedAvatarName: String // Deklarasikan selectedAvatarName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_anak)

        editTextName = findViewById(R.id.editTextName)
        editTextAge = findViewById(R.id.editTextAge)
        radioGroupGender = findViewById(R.id.radioGroupGender)
        imageViewAvatar = findViewById(R.id.imageViewAvatar)
        buttonSaveChild = findViewById(R.id.buttonSaveChild)
        buttonNextAvatar = findViewById(R.id.buttonNextAvatar)
        buttonPrevAvatar = findViewById(R.id.buttonPrevAvatar)

        // Set selectedAvatarName ke nilai awal sesuai dengan jenis kelamin yang dipilih
        selectedAvatarName = maleAvatars[currentAvatarIndex]

        // Handle avatar character selection (e.g., when clicked)
        imageViewAvatar.setOnClickListener {
            // Implement logic to allow user to select an avatar character
            showAvatar(currentAvatarIndex)
        }

        // Handle button click to save child data and navigate to ParentPageActivity
        buttonSaveChild.setOnClickListener {
            val name = editTextName.text.toString()
            val age = editTextAge.text.toString()
            val selectedGenderId = radioGroupGender.checkedRadioButtonId
            val gender = if (selectedGenderId == R.id.radioButtonMale) "Laki-laki" else "Perempuan"

            // Menentukan avatar anak berdasarkan jenis kelamin dan indeks saat ini
            val selectedAvatarName = if (selectedGenderId == R.id.radioButtonMale) {
                maleAvatars[currentAvatarIndex]
            } else {
                femaleAvatars[currentAvatarIndex]
            }

            // Membuat objek Child baru dengan data anak dan avatar
            val child = Child(name, age, gender, selectedAvatarName)

            // Membuat intent dan mengirim data anak dan avatar ke ParentPageActivity
            val intent = Intent()
            intent.putExtra("childData", child)
            setResult(RESULT_OK, intent)
            finish()
        }

        // Handle next avatar button click
        buttonNextAvatar.setOnClickListener {
            nextAvatar()
        }

        // Handle previous avatar button click
        buttonPrevAvatar.setOnClickListener {
            prevAvatar()
        }
    }

    private fun showAvatar(index: Int) {
        val selectedGenderId = radioGroupGender.checkedRadioButtonId
        val selectedAvatarList = if (selectedGenderId == R.id.radioButtonMale) {
            maleAvatars
        } else {
            femaleAvatars
        }

        selectedAvatarName = selectedAvatarList[index]

        val avatarResourceId = resources.getIdentifier(
            selectedAvatarName, "drawable", packageName
        )
        imageViewAvatar.setImageResource(avatarResourceId)
    }

    private fun nextAvatar() {
        currentAvatarIndex++
        if (currentAvatarIndex >= maleAvatars.size) {
            currentAvatarIndex = 0
        }
        showAvatar(currentAvatarIndex)
    }

    private fun prevAvatar() {
        currentAvatarIndex--
        if (currentAvatarIndex < 0) {
            currentAvatarIndex = maleAvatars.size - 1
        }
        showAvatar(currentAvatarIndex)
    }
}
