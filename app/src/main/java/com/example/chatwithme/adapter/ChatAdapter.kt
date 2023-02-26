package com.example.chatwithme.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.chatwithme.R
import com.example.chatwithme.data.model.Contact

class ChatAdapter : RecyclerView.Adapter<ChatAdapter.ItemViewHolder>() {
    private var dataset = mutableListOf<String>()


    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val myChatText = view.findViewById<TextView>(R.id.chat_myitem_text)
    val otherChat = view.findViewById<TextView>(R.id.chat_hisitem_text)
    }

   fun submitlist(list:MutableList<String>) {
        dataset = list
   //notifyDataSetChanged()
        notifyItemInserted(0)
    }

   //neuer Viewholder erstellt
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.chat_item, parent, false)

        return ItemViewHolder(itemLayout)
    }

    // BEFÜLLEN DES VIEWHOLDERS
    // hier findet der Recyclingprozess statt
    // die vom ViewHolder bereitgestellten Parameter werden verändert
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val chat = dataset[position]

        holder.myChatText.text = chat
        holder.otherChat.text = listOf("Hallo", "Cio", "Danke", "Mir geht es gut", "Ich hau ab...",
            "nee, nicht so", "hmm", "???").random()
    }

    //damit das LAyout weiß wie lang die Liste ist
    override fun getItemCount(): Int {
        return dataset.size
    }
}


