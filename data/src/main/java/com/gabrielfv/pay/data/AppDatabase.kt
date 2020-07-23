package com.gabrielfv.pay.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gabrielfv.pay.data.access.UserDao
import com.gabrielfv.pay.data.entities.User

@Database(
    entities = [
        User::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}