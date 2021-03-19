package com.example.ktapp

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {
    val readAllData: LiveData<List<User>> = userDao.readAllData()

   suspend fun addUser(user:User){
        userDao.addUser(user)
    }
    suspend fun upDateData(user: User){
        userDao.upDateData(user)

    }


}