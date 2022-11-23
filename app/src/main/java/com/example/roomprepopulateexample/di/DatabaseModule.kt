package com.example.roomprepopulateexample.di

import android.content.Context
import com.example.roomprepopulateexample.data.local.UserDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    fun provideUserDatabase(@ApplicationContext context: Context) : UserDatabase = UserDatabase.getDatabase(context)

    @Provides
    fun provideUserDao(userDatabase: UserDatabase) = userDatabase.userDao
}