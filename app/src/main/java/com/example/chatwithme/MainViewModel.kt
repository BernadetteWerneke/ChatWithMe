package com.example.chatwithme

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatwithme.data.Repository
import com.example.chatwithme.data.model.Contact
import kotlinx.coroutines.launch

class MainViewModel: ViewModel(){
    private val repository=Repository()

    //contact
    private val _contacts= MutableLiveData<MutableList<Contact>>()
    val contacts: LiveData<MutableList<Contact>>
        get() = _contacts

    //detail chat
    private val _chatList= MutableLiveData<MutableList<String>>()
    val chatList: LiveData<MutableList<String>>
        get() = _chatList

    init {
        loadcontact()
        _contacts.value=repository.getcontacts()
    }

    private fun loadcontact(){
        viewModelScope.launch {
            _contacts.value=repository.getcontacts()
        }
    }

    fun loadChat(name: String) {
        val chatContact = _contacts.value?.find { it.name == name }

        if (chatContact != null) {
            _chatList.value = chatContact.chat
        }
    }

    fun addChat(chat: String) {
        _chatList.value?.add(0, chat)
        Log.d("add", "add")
        _chatList.value = _chatList.value
    }
}