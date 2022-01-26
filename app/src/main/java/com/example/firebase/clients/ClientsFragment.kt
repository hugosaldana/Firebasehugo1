package com.example.firebase.clients

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.firebase.R
import com.example.firebase.databinding.FragmentClientsBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


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
        val db = Firebase.firestore


        binding.CrearButton.setOnClickListener { view : View ->
            val nom = binding.clientsnom.text.toString()
            val email = binding.clientsemail.text.toString()
            val contr = binding.clientscontrasenya.text.toString()

            val user = hashMapOf(
                "Email" to email,
                "Nom" to nom,
                "Password" to contr
            )

            db.collection("Users")
                .add(user)
                .addOnSuccessListener { documentReference ->
                    Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w(TAG, "Error adding document", e)
                }
        }

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_clients, container, false)
    }



}