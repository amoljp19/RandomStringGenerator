package com.softaai.randomstringgenerator.data

import com.softaai.randomstringgenerator.domain.RandomGeneratedString
import com.softaai.randomstringgenerator.domain.Repository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext


/**
 * Created by amoljp19 on 12/20/2024.
 * softAai Apps.
 */
class RandomStringGeneratorRepository (private val source: RandomStringDataSource, private val coroutineDispatcher: CoroutineDispatcher) : Repository {
    override suspend fun generateRandomString(length: Int) : RandomGeneratedString {
        return withContext(coroutineDispatcher) {
            source.generateRandomString(length)
        }
    }
}