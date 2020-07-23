package com.gabrielfv.pay.data.access

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.gabrielfv.pay.data.entities.User

@Dao
interface UserDao {
    @Query("SELECT * FROM user ORDER BY uuid ASC")
    suspend fun getAll(): List<User>

    @Insert
    suspend fun insertAll(vararg users: User)

    @Query("UPDATE user SET balance = :balance WHERE uuid = :uuid")
    suspend fun updateUserBalance(uuid: Int, balance: Int)
}