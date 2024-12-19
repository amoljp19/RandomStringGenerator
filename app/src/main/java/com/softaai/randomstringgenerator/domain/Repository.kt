package com.softaai.randomstringgenerator.domain


/**
 * Created by amoljp19 on 12/20/2024.
 * softAai Apps.
 */
interface Repository {
    suspend fun generateRandomString(length: Int) : RandomGeneratedString

    //fun deletePerticularString()

   // fun deleteAllStrings()
}