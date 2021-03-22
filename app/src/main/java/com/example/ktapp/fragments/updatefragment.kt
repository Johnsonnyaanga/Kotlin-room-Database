package com.example.ktapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.ktapp.R
import com.example.ktapp.ViewModels.UserViewModel
import com.example.ktapp.models.User
import com.example.ktapp.fragments.updatefragmentArgs
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import java.lang.Integer.parseInt

class updatefragment : Fragment() {
    private  val args by navArgs<updatefragmentArgs>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_updatefragment, container, false)
        // Inflate the layout for this fragment
        val fnamee = view.findViewById<TextInputEditText>(R.id.fname_update)
            fnamee.setText(args.currentUser.firstName)
        val lnamee = view.findViewById<TextInputEditText>(R.id.lname_update)
            lnamee.setText(args.currentUser.lastName)
        val agee = view.findViewById<TextInputEditText>(R.id.age_update)
            agee.setText(args.currentUser.age.toString())
        view.findViewById<MaterialButton>(R.id.submit_update)
            .setOnClickListener(View.OnClickListener {
            view ->

            val mViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
            val user: User = User(args.currentUser.id,fnamee.text.toString(),lnamee.text.toString(),parseInt(agee.text.toString()))
            mViewModel.upDateData(user)
            Toast.makeText(context?.applicationContext,"updated succesifuly",Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.update_to_listfragment)
        })







        return view
    }


}