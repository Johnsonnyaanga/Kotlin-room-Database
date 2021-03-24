package com.example.ktapp.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.ktapp.R
import com.example.ktapp.ViewModels.UserViewModel
import com.example.ktapp.models.User
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText


class Add : Fragment() {
    private lateinit var mUserViewModel: UserViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.add_user, container, false)
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)


        val firstname = view.findViewById<TextInputEditText>(R.id.fname)
        val lastname = view.findViewById<TextInputEditText>(R.id.lname)
        val age = view.findViewById<TextInputEditText>(R.id.age)
        val submit = view.findViewById<MaterialButton>(R.id.submit)

        submit.setOnClickListener(View.OnClickListener {
            view ->

            insertDataToDB(firstname.text.toString(),lastname.text.toString(),age.editableText)

        })







        return view
    }

    private fun insertDataToDB(fname:String, lname:String,age: Editable) {

        val context = activity?.applicationContext

        if (inputCheck(fname,lname,age)){
            val user = User(0,fname,lname,Integer.parseInt(age.toString()))
            mUserViewModel.addUser(user)
            Toast.makeText(context,"added succesifuly", Toast.LENGTH_LONG).show()

        }else{
            Toast.makeText(context,"Nigga insert stuff", Toast.LENGTH_LONG).show()
        }

    }
    private fun inputCheck(firstname:String,lastname: String,age: Editable):Boolean{
        return !(TextUtils.isEmpty(firstname) && TextUtils.isEmpty(lastname) && age.isEmpty())


    }


}