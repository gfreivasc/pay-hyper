package com.gabrielfv.pay.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) val uuid: Int = 0,
    val balance: Int = 0
)