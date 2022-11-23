package com.example.roomprepopulateexample.data.repository

import com.example.roomprepopulateexample.data.local.User
import com.example.roomprepopulateexample.data.local.UserDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepository @Inject constructor(private val userDao: UserDao) {

     fun getAllUsers() : Flow<List<User>> = userDao.getUsers()
}