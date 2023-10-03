package com.example.asemtemp2

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import com.example.asemtemp2.Clothes

data class Clothes(val name: String, val price: Int)


class ShopActivity : AppCompatActivity() {
    private lateinit var listViewClothes: ListView
    private lateinit var textViewMoney: TextView
    private var money = 0
    private val clothesList = listOf(
        Clothes("Baju A", 50),
        Clothes("Baju B", 30),
        Clothes("Baju C", 40),
        // ... tambahkan baju lainnya di sini
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)

        listViewClothes = findViewById(R.id.listViewClothes)
        textViewMoney = findViewById(R.id.textViewMoney)

        // Inisialisasi adapter untuk ListView
        val adapter = ClothesAdapter(this, clothesList)
        listViewClothes.adapter = adapter

        // Menampilkan uang awal pengguna
        updateMoney()

        // Menambahkan listener untuk item di ListView
        listViewClothes.setOnItemClickListener { _, _, position, _ ->
            val selectedClothes = clothesList[position]
            if (money >= selectedClothes.price) {
                // Pengguna memiliki cukup uang, kurangi uang dan update tampilan
                money -= selectedClothes.price
                updateMoney()
                showToast("Anda telah membeli ${selectedClothes.name}")
            } else {
                showToast("Uang tidak cukup untuk membeli ${selectedClothes.name}")
            }
        }
    }

    private fun updateMoney() {
        // Menampilkan uang terbaru
        textViewMoney.text = "Uang: $money"
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}

class ClothesAdapter(private val context: Context, private val clothesList: List<Clothes>) : BaseAdapter() {

    override fun getCount(): Int {
        return clothesList.size
    }

    override fun getItem(position: Int): Any {
        return clothesList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.clothes_list_item, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val clothes = getItem(position) as Clothes
        viewHolder.clothesNameTextView.text = clothes.name
        viewHolder.clothesPriceTextView.text = "Harga: ${clothes.price}"

        return view
    }

    private class ViewHolder(view: View) {
        val clothesNameTextView: TextView = view.findViewById(R.id.clothesNameTextView)
        val clothesPriceTextView: TextView = view.findViewById(R.id.clothesPriceTextView)
    }
}