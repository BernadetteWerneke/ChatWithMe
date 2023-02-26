package com.example.chatwithme.data.model

data class Contact (
    val image: Int,
    val name: String,
    val chat: MutableList<String>
    )