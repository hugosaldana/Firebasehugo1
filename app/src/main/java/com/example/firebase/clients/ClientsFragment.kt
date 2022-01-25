package com.example.firebase.clients

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.firebase.R
import com.example.firebase.databinding.FragmentClientsBinding


class ClientsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentClientsBinding>(inflater,
            R.layout.fragment_clients,container,false)

        binding.clientsenrrere.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_clientsFragment_to_homeFragment)
        }



        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_clients, container, false)
    }

}