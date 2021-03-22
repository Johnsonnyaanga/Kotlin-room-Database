package com.example.ktapp

import androidx.lifecycle.LiveData
import com.example.ktapp.Room.UserDao
import com.example.ktapp.models.User

class UserRepository(private val userDao: UserDao) {
    val readAllData: LiveData<List<User>> = userDao.readAllData()

   suspend fun addUser(user: User){
        userDao.addUser(user)
    }
    suspend fun upDateData(user: User){
        userDao.upDateData(user)

    }


}