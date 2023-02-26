package com.example.chatwithme.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.chatwithme.MainViewModel
import com.example.chatwithme.adapter.ChatAdapter
import com.example.chatwithme.databinding.FragmentChatBinding
import com.example.uandme.adapter.ContactAdapter

class ChatFragment: Fragment() {
    private lateinit var binding: FragmentChatBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChatBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val name = requireArguments().getString("name", "not found")

        //name auch für Titel im Chat nutzen
        binding.materialToolbar.title = name
        //backbutton functionality
        binding.materialToolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }

        viewModel.loadChat(name)

        val chatAdapter = ChatAdapter()
        binding.recyclerView.adapter = chatAdapter

        viewModel.chatList.observe(viewLifecycleOwner){
            chatAdapter.submitlist(it)
        }

        // send button functionality
        binding.chatSendButton.setOnClickListener {
            val newChat = binding.chatEditText.text.toString()
            if (newChat==""){
                Toast.makeText(context,"Please type your message",Toast.LENGTH_SHORT).show()
            } else {
                viewModel.addChat(newChat)
                Log.d("send", "sendbutton")
                binding.chatEditText.setText("")
            }
        }
    }
}