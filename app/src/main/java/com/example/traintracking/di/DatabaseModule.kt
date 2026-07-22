package com.example.traintracking.di

import android.content.Context
import androidx.room.Room
import com.example.traintracking.data.local.TrainDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideTrainDatabase(
        @ApplicationContext context: Context
    ): TrainDatabase {
        return Room.databaseBuilder(
            context,
            TrainDatabase::class.java,
            "train_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideTrainDao(database: TrainDatabase) = database.trainDao()
}
