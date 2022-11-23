package com.example.roomprepopulateexample.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM user_table")
    fun getUsers() : Flow<List<User>>

    @Insert
    suspend fun insertUser(user: User)

    @Insert
    suspend  fun insertUserList(users : List<User>)
}