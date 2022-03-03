package com.example.attractorsoftware.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.attractorsoftware.R
import com.example.attractorsoftware.databinding.ViewImagesBinding
import com.squareup.picasso.Picasso

class AdapterImages : RecyclerView.Adapter<AdapterImages.ViewHolder>() {
    private val data = mutableListOf<String>()

    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        private val binding = ViewImagesBinding.bind(item)

        fun bind(item: String) {
            Picasso.get().load(item).into(binding.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val item =
            LayoutInflater.from(parent.context).inflate(R.layout.view_images, parent, false)
        return ViewHolder(item)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount() = data.size


    @SuppressLint("NotifyDataSetChanged")
    fun setItems(list: List<String>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }
}