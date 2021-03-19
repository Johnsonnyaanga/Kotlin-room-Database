package com.example.ktapp

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)
    @Query("SELECT * FROM user_table ORDER BY id ASC ")
    fun readAllData(): LiveData<List<User>>
    @Update
    suspend fun upDateData(user: User)


}