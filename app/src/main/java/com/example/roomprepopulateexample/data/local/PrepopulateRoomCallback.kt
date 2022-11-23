package com.example.roomprepopulateexample.data.local

import android.content.Context
import android.util.Log
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.roomprepopulateexample.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONArray
import java.lang.Exception

class PrepopulateRoomCallback(private val context: Context) : RoomDatabase.Callback() {

    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)

        CoroutineScope(Dispatchers.IO).launch {
            prePopulateUsers(context)
        }
    }

    suspend fun prePopulateUsers(context: Context) {
        try {
            val userDao = UserDatabase.getDatabase(context).userDao

            val userList: JSONArray =
                context.resources.openRawResource(R.raw.users).bufferedReader().use {
                    JSONArray(it.readText())
                }

            userList.takeIf { it.length() > 0 }?.let { list ->
                for (index in 0 until list.length()) {
                    val userObj = list.getJSONObject(index)
                    userDao.insertUser(
                        User(
                            userObj.getInt("userId"),
                            userObj.getString("userName")
                        )
                    )

                }
                Log.e("User App", "successfully pre-populated users into database")
            }
        } catch (exception: Exception) {
            Log.e(
                "User App",
                exception.localizedMessage ?: "failed to pre-populate users into database"
            )
        }
    }
}