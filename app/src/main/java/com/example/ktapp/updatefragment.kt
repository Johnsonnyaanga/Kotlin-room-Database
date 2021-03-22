package com.example.ktapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.textfield.TextInputEditText

class updatefragment : Fragment() {
    private  val args by navArgs<updatefragmentArgs>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_updatefragment, container, false)
        // Inflate the layout for this fragment
        view.findViewById<TextInputEditText>(R.id.fname_update).setText(args.currentUser.firstName)
        view.findViewById<TextInputEditText>(R.id.lname_update).setText(args.currentUser.lastName)
        view.findViewById<TextInputEditText>(R.id.age_update).setText(args.currentUser.age.toString())
        view.findViewById<TextInputEditText>(R.id.submit_update).setOnClickListener(View.OnClickListener {
            view ->
            val mViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
            val user:User = User(args.currentUser.id,args.currentUser.firstName,args.currentUser.lastName,args.currentUser.age)
            mViewModel.upDateData(user)
            Toast.makeText(context?.applicationContext,"updated succesifuly",Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.tolistfragment)
        })







        return view
    }


}