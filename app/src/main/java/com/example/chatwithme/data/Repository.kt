package com.example.chatwithme.data

import com.example.chatwithme.R
import com.example.chatwithme.data.model.Contact

class Repository {
    fun getcontacts(): MutableList<Contact> {
        return mutableListOf(
            Contact(R.drawable.brad, "Brad", mutableListOf()),
            Contact(R.drawable.emma, "Emma", mutableListOf()),
            Contact(R.drawable.jennifer, "Jennifer", mutableListOf()),
            Contact(R.drawable.johnny, "Johnny", mutableListOf()),
            Contact(R.drawable.keanu, "Keanu", mutableListOf()),
            Contact(R.drawable.leo, "Leo", mutableListOf()),
            Contact(R.drawable.margot, "Margot", mutableListOf()),
            Contact(R.drawable.reese, "Reese", mutableListOf()),
            Contact(R.drawable.sandra, "Sandra", mutableListOf()),
            Contact(R.drawable.scarlett, "Scarlett", mutableListOf()),
            Contact(R.drawable.tom, "Tom", mutableListOf()),
            Contact(R.drawable.will, "Will", mutableListOf())
        )
    }
}