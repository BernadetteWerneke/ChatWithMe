package com.example.chatwithme.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.chatwithme.MainViewModel
import com.example.chatwithme.databinding.FragmentHomeBinding
import com.example.uandme.adapter.ContactAdapter

class HomeFragment : Fragment(){
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val contactAdapter = ContactAdapter()
        binding.contactRecycler.adapter = contactAdapter
        viewModel.contacts.observe(viewLifecycleOwner){
            contactAdapter.submitlist(it)
        }

    }
}