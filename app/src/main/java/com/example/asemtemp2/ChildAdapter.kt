package com.example.asemtemp2

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.asemtemp2.model.Child
import com.example.asemtemp2.ChildProfileActivity

class ChildAdapter(private val children: List<Child>) : RecyclerView.Adapter<ChildAdapter.ChildViewHolder>() {

    inner class ChildViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageViewChildAvatar: ImageView = itemView.findViewById(R.id.imageViewChildAvatar)
        val textViewChildName: TextView = itemView.findViewById(R.id.textViewChildName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChildViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.child_item, parent, false)
        return ChildViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ChildViewHolder, position: Int) {
        val child = children[position]

        // Tampilkan avatar anak sesuai dengan nama avatar yang diterima
        val avatarName = child.selectedAvatarName
        val avatarResourceId = holder.itemView.resources.getIdentifier(
            avatarName, "drawable", holder.itemView.context.packageName
        )
        holder.imageViewChildAvatar.setImageResource(avatarResourceId)

        // Set nama anak di samping avatar
        holder.textViewChildName.text = child.name

        // Handle aksi ketika item anak diklik
        holder.itemView.setOnClickListener {
            // Implementasi aksi ketika item anak diklik di sini
            // Contoh: Buka halaman profil anak dengan data child
            val intent = Intent(holder.itemView.context, ChildProfileActivity::class.java)
            intent.putExtra("childData", child)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return children.size
    }
}
