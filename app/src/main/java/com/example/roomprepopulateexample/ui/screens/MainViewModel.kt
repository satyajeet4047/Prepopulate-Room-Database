package com.example.roomprepopulateexample.ui.screens

import androidx.lifecycle.ViewModel
import com.example.roomprepopulateexample.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel(){

    val userList get() =  userRepository.getAllUsers()
}