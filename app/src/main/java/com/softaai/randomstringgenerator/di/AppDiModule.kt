package com.softaai.randomstringgenerator.di

import android.app.Application
import android.content.ContentResolver
import android.content.Context
import com.softaai.randomstringgenerator.data.RandomStringDataSource
import com.softaai.randomstringgenerator.data.RandomStringGeneratorRepository
import com.softaai.randomstringgenerator.domain.GenerateRandomStringUseCase
import com.softaai.randomstringgenerator.domain.RandomStringRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier


/**
 * Created by amoljp19 on 12/20/2024.
 * softAai Apps.
 */

@Module
@InstallIn(SingletonComponent::class)
object AppDiModule {
    @Provides
    fun provideRandomStringRepository(randomStringDataSource : RandomStringDataSource): RandomStringRepository = RandomStringGeneratorRepository(randomStringDataSource)
    @Provides
    fun provideGenerateRandomStringUseCase(repository: RandomStringRepository): GenerateRandomStringUseCase = GenerateRandomStringUseCase(repository)

    @Provides
    fun provideRandomStringDataSource(application: Application): RandomStringDataSource = RandomStringDataSource(application)


}