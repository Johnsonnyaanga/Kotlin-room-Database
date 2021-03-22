package com.example.ktapp

import android.app.Activity
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFragment : Fragment() {
    private lateinit var addfloat: FloatingActionButton
    private lateinit var Recycler: RecyclerView
    private lateinit var mUserViewModel:UserViewModel




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_list, container, false)

        val context = activity?.applicationContext

        addfloat = view.findViewById(R.id.add_user_float)
        Recycler = view.findViewById(R.id.recycler)
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        val adapter = ListAdapter()
        Recycler.adapter = adapter
        Recycler.layoutManager = LinearLayoutManager(context)
        mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer {
                user ->
            adapter.setData(user)
        })

        addfloat.setOnClickListener(View.OnClickListener {
                view ->
            // go to add fragment
            findNavController().navigate(R.id.toaddfragment)
        })




        return view
    }



}