package com.softaai.randomstringgenerator.domain

import android.health.connect.datatypes.units.Length
import kotlinx.coroutines.flow.Flow


/**
 * Created by amoljp19 on 12/20/2024.
 * softAai Apps.
 */

//avoided etra layer of interface for simplicity, but we can go for usecases interface also
class GenerateRandomStringUseCase(private val repository: RandomStringRepository) {

    suspend fun generateRandomString(length: Int): Flow<RandomGeneratedString> = repository.generateRandomString(length)
}