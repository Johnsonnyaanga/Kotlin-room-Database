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
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupActionBarWithNavController(findNavController(R.id.fragment))





















    }

    override fun onSupportNavigateUp(): Boolean {
        val naController = findNavController(R.id.fragment)
        return naController.navigateUp() || super.onSupportNavigateUp()

    }

    private fun showDialog() {
        val mDialogview = LayoutInflater.from(this).inflate(R.layout.add_user,null)
        val AlertDialogB = AlertDialog.Builder(this)
            .setView(mDialogview)








        val AlertBulider = AlertDialogB.show()


    }


}