package com.example.attractorsoftware.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.attractorsoftware.R
import com.example.attractorsoftware.databinding.ViewCompanyBinding
import com.example.attractorsoftware.models.Company

class AdapterCompany : RecyclerView.Adapter<AdapterCompany.ViewHolder>() {
    private val data = mutableListOf<Company>()

    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {

        private val binding = ViewCompanyBinding.bind(item)

        fun bind(item: Company) {
            with(binding) {
                nameCompany.text = item.name
                positionCompany.text = item.position
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val item =
            LayoutInflater.from(parent.context).inflate(R.layout.view_company, parent, false)
        return ViewHolder(item)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }

    override fun getItemCount() = data.size


    @SuppressLint("NotifyDataSetChanged")
    fun setItems(list: List<Company>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }
}