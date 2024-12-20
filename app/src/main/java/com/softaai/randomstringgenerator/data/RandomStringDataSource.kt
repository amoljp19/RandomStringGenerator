package com.softaai.randomstringgenerator.data

import android.app.Application
import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import com.softaai.randomstringgenerator.domain.RandomGeneratedString
import com.softaai.randomstringgenerator.domain.resource.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import java.io.IOException


/**
 * Created by amoljp19 on 12/20/2024.
 * softAai Apps.
 */
class RandomStringDataSource(private val application: Application) {

    suspend fun generateRandomString(length: Int): Flow<Resource<RandomGeneratedString>> = flow {

        withContext(Dispatchers.IO){
            emit(Resource.Loading())
            val strBuild = StringBuilder()

            try {

                val cursor = application.contentResolver.query(
                    Uri.parse("content://com.iav.contestdataprovider/text"),
                    null,
                    ContentResolver.QUERY_ARG_LIMIT,
                    null,
                    null
                )


                cursor?.let {
                    cursor.moveToFirst()


                    while (!cursor.isAfterLast) {
                        strBuild.append(
                            """
    
    ${cursor.getString(cursor.getColumnIndexOrThrow("data"))}
    """.trimIndent()
                        )
                        cursor.moveToNext()
                    }
                    cursor.close()
                }

            } catch (e: Exception){
                emit(
                    Resource.Error(
                        message = "Error in Generating Random String"
                    )
                )
            }


            emit(Resource.Success(RandomGeneratedString(strBuild.toString())))
        }

    }

}