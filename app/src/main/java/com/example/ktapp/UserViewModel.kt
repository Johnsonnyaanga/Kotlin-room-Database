package com.example.ktapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Appendable

class UserViewModel(application: Application):AndroidViewModel(application) {
    val readAllData: LiveData<List<User>>
   private val repository:UserRepository
    init {
       val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllData
    }

    fun addUser(user:User){
        viewModelScope.launch(Dispatchers.IO){
            repository.addUser(user)
        }
    }
    fun upDateData(user: User){
        viewModelScope.launch {
            repository.upDateData(user)
        }
    }
}