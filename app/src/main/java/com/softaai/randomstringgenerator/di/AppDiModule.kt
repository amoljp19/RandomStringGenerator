package com.softaai.randomstringgenerator.di

import android.app.Application
import com.softaai.randomstringgenerator.data.RandomStringDataSource
import com.softaai.randomstringgenerator.data.RandomStringGeneratorRepository
import com.softaai.randomstringgenerator.domain.GenerateRandomStringUseCase
import com.softaai.randomstringgenerator.domain.RandomStringRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


/**
 * Created by amoljp19 on 12/20/2024.
 * softAai Apps.
 */

@Module
@InstallIn(SingletonComponent::class)
object AppDiModule {
    @Provides
    fun provideRandomStringRepository(randomStringDataSource: RandomStringDataSource): RandomStringRepository =
        RandomStringGeneratorRepository(randomStringDataSource)

    @Provides
    fun provideGenerateRandomStringUseCase(repository: RandomStringRepository): GenerateRandomStringUseCase =
        GenerateRandomStringUseCase(repository)

    @Provides
    fun provideRandomStringDataSource(application: Application): RandomStringDataSource =
        RandomStringDataSource(application)


}