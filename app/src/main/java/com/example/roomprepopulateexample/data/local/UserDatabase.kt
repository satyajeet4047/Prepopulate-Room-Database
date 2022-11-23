package com.example.roomprepopulateexample.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1, exportSchema = true)
abstract class UserDatabase : RoomDatabase() {

    abstract val userDao: UserDao

    companion object {

        private var DB_INSTANCE: UserDatabase? = null

        fun getDatabase(context: Context): UserDatabase {
            synchronized(this) {
                var instance = DB_INSTANCE
                if (instance == null) {
                    DB_INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        UserDatabase::class.java,
                        "User_DB"
                    )
                    .addCallback(PrepopulateRoomCallback(context))
                    .build()
                    instance = DB_INSTANCE
                }

                return instance!!
            }

        }

    }


}