package com.example.ktapp

import android.app.AlertDialog
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.*
import android.view.View.inflate
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {
private lateinit var addfloat: FloatingActionButton
    private lateinit var Recycler: RecyclerView
    private lateinit var rootLayout: RelativeLayout
    private lateinit var mUserViewModel:UserViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        rootLayout = findViewById(R.id.root)
        addfloat = findViewById(R.id.add_user_float)
        Recycler = findViewById(R.id.recycler)







        val adapter = ListAdapter()
        Recycler.adapter = adapter
        Recycler.layoutManager = LinearLayoutManager(this)
        mUserViewModel.readAllData.observe(/*viewlifecycleowner*/this, Observer {
            user ->
            adapter.setData(user)
        })


        addfloat.setOnClickListener(View.OnClickListener {
            view ->
            showDialog()
        })










    }

    private fun showDialog() {
        val mDialogview = LayoutInflater.from(this).inflate(R.layout.add_user,null)
        val AlertDialogB = AlertDialog.Builder(this)
            .setView(mDialogview)

        val firstname = mDialogview.findViewById<TextInputEditText>(R.id.fname)
        val lastname = mDialogview.findViewById<TextInputEditText>(R.id.lname)
        val age = mDialogview.findViewById<TextInputEditText>(R.id.age)
        val submit = mDialogview.findViewById<MaterialButton>(R.id.submit)

        submit.setOnClickListener(View.OnClickListener {
                view ->
            insertDataToDB(firstname.text.toString(),lastname.text.toString(),age.editableText)

        })





        val AlertBulider = AlertDialogB.show()


    }

    private fun insertDataToDB(fname:String, lname:String,age:Editable) {

     if (inputCheck(fname,lname,age)){
         val user = User(0,fname,lname,Integer.parseInt(age.toString()))
         mUserViewModel.addUser(user)
         Toast.makeText(this,"added succesifuly",Toast.LENGTH_LONG).show()

     }else{
         Toast.makeText(this,"Nigga insert stuff",Toast.LENGTH_LONG).show()
     }

    }
    private fun inputCheck(firstname:String,lastname: String,age: Editable):Boolean{
        return !(TextUtils.isEmpty(firstname) && TextUtils.isEmpty(lastname) && age.isEmpty())


    }
}