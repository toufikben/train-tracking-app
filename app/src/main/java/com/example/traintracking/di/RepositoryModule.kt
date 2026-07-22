package com.example.traintracking.di

import com.example.traintracking.data.repository.TrainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideTrainRepository(): TrainRepository {
        return TrainRepository()
    }
}