package com.gabrielfv.pay.data

import android.content.Context
import androidx.room.Room
import com.gabrielfv.pay.data.access.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object DataModule {

    @Singleton
    @Provides
    fun provideAppDatabase(context: Context): AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "pay-database"
    ).build()

    @Provides
    fun providesUserDao(appDatabase: AppDatabase): UserDao = appDatabase.userDao()
}