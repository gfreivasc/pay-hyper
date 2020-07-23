package com.gabrielfv.pay.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey val uuid: Int,
    val balance: Int
)