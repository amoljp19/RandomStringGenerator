package com.softaai.randomstringgenerator.data

import com.softaai.randomstringgenerator.domain.RandomGeneratedString
import com.softaai.randomstringgenerator.domain.RandomStringRepository
import com.softaai.randomstringgenerator.domain.resource.Resource
import kotlinx.coroutines.flow.Flow


/**
 * Created by amoljp19 on 12/20/2024.
 * softAai Apps.
 */
class RandomStringGeneratorRepository(private val source: RandomStringDataSource) :
    RandomStringRepository {
    override suspend fun generateRandomString(length: Int): Flow<Resource<RandomGeneratedString>> =
        source.generateRandomString(length)
}