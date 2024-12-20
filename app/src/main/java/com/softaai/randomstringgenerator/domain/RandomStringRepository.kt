package com.softaai.randomstringgenerator.domain

import com.softaai.randomstringgenerator.domain.resource.Resource
import kotlinx.coroutines.flow.Flow


/**
 * Created by amoljp19 on 12/20/2024.
 * softAai Apps.
 */
interface RandomStringRepository {
    suspend fun generateRandomString(length: Int) : Flow<Resource<RandomGeneratedString>>
}