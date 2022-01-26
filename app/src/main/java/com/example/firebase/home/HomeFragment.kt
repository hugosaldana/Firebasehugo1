package com.example.firebase.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.firebase.R
import com.example.firebase.databinding.FragmentHomeBinding



class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(inflater,
            R.layout.fragment_home,container,false)

        binding.ButtonClients.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_homeFragment_to_clientsFragment)
        }

        binding.ButtonMenu.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_homeFragment_to_menuFragment)
        }

        binding.ButtonReviews.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_homeFragment_to_reviewsFragment)
        }

        binding.tencarsesiobutton.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_homeFragment_to_loginFragment)
        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


}