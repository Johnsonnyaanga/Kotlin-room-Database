package com.example.ktapp

import android.app.AlertDialog
import android.content.Context
import android.text.Editable
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

     private var userlist = emptyList<User>()




     class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
         return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.data_row, parent, false))
     }

     override fun getItemCount(): Int {
         return userlist.size
     }

     override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
         var currentItem = userlist[position]
         holder.itemView.findViewById<TextView>(R.id.idno).text = currentItem.id.toString()
         holder.itemView.findViewById<TextView>(R.id.fname_id).text = currentItem.firstName
         holder.itemView.findViewById<TextView>(R.id.lname_id).text = currentItem.lastName
         holder.itemView.findViewById<TextView>(R.id.age_id).text = currentItem.age.toString()
         holder.itemView.findViewById<ConstraintLayout>(R.id.full_row).setOnClickListener(View.OnClickListener { v ->


             val context: Context = holder.itemView.context
             showDialog(context, currentItem.firstName, currentItem.lastName, currentItem.age.toString())


         })

     }
     fun setData(user: List<User>){
         this.userlist = user
         notifyDataSetChanged()
     }
    private fun showDialog(ctx: Context, f: String, l: String, a: String) {



        val mDialogview = LayoutInflater.from(ctx).inflate(R.layout.update_user, null)
        val AlertDialogB = AlertDialog.Builder(ctx)
                .setView(mDialogview)

        val firstname = mDialogview.findViewById<TextInputEditText>(R.id.fname)
                firstname.setText(f)
        val lastname = mDialogview.findViewById<TextInputEditText>(R.id.lname)
                lastname.setText(l)
        val age = mDialogview.findViewById<TextInputEditText>(R.id.age)
                age.setText(a.toString())
        val submit = mDialogview.findViewById<MaterialButton>(R.id.submit)



        submit.setOnClickListener(View.OnClickListener { view ->


            val user = User(1, firstname.toString(), lastname.toString(), Integer.parseInt(age.toString()))
            val mViewModel: UserViewModel by
            mViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
            mViewModel.upDateData(user)


        })





        val AlertBulider = AlertDialogB.show()


    }

    private fun updateData(ctx: ViewModelStoreOwner, currentId: Int, fname: String, lname: String, age: Editable) {
        if (inputCheck(fname, lname, age)){
            val user = User(currentId, fname, lname, Integer.parseInt(age.toString()))
           val  mViewModel:UserViewModel
           mViewModel = ViewModelProvider(ctx).get(UserViewModel::class.java)
            mViewModel.upDateData(user)




        }else{
        }

    }
    private fun inputCheck(firstname: String, lastname: String, age: Editable):Boolean{
        return !(TextUtils.isEmpty(firstname) && TextUtils.isEmpty(lastname) && age.isEmpty())


    }



   



}