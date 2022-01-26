package com.example.firebase.login

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
import com.example.firebase.databinding.FragmentLoginBinding
import com.google.firebase.firestore.ktx.firestore

import com.google.firebase.ktx.Firebase


class LoginFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(inflater,
            R.layout.fragment_login,container,false)

        val db = Firebase.firestore


        binding.loginbutton.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_loginFragment_to_homeFragment)

            val email = binding.editTextTextEmailAddress.text.toString()
            val contr = binding.editTextTextPassword.text.toString()

            val user = hashMapOf(
                "Email" to email,
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
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

}