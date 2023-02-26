package com.example.uandme.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.chatwithme.R
import com.example.chatwithme.data.model.Contact
import com.example.chatwithme.ui.HomeFragmentDirections

class ContactAdapter : RecyclerView.Adapter<ContactAdapter.ItemViewHolder>(){
    private var dataset = mutableListOf<Contact>()
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name =view.findViewById<TextView>(R.id.contact_name_text)
        val image =view.findViewById<ImageView>(R.id.contact_item_image)
        val cardView = view.findViewById<CardView>(R.id.contact_card)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.contact_item, parent, false)

        return ItemViewHolder(itemLayout)
    }
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val contact:Contact=dataset[position]
        holder.image.setImageResource(contact.image)
        holder.name.text=contact.name

      holder.cardView.setOnClickListener(){
            holder.itemView.findNavController()
                .navigate(HomeFragmentDirections.actionHomeFragmentToChatFragment(contact.name))
        }

    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    fun submitlist(list:MutableList<Contact>) {
        dataset=list
        notifyDataSetChanged()
    }
}