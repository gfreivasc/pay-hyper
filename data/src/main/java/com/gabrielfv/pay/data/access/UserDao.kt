package com.gabrielfv.pay.data.access

import androidx.room.Dao
import androidx.room.Query
import com.gabrielfv.pay.data.entities.User

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    suspend fun getAll(): List<User>
}