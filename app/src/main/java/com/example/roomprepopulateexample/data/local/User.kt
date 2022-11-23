package com.example.roomprepopulateexample.data.local

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "userId")
    val id : Int,
    @NonNull
    @ColumnInfo(name ="userName")
    val name : String
)