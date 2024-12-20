package com.softaai.randomstringgenerator.data

import android.app.Application
import android.content.ContentResolver
import android.net.Uri
import android.os.Bundle
import android.util.Log
import com.softaai.randomstringgenerator.domain.RandomGeneratedString
import com.softaai.randomstringgenerator.domain.resource.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


/**
 * Created by amoljp19 on 12/20/2024.
 * softAai Apps.
 */
class RandomStringDataSource(private val application: Application) {

    suspend fun generateRandomString(length: Int): Flow<Resource<RandomGeneratedString>> = flow {

        emit(Resource.Loading())
        val strBuild = StringBuilder()

        try {

            val bundle = Bundle().apply {
                putInt(ContentResolver.QUERY_ARG_LIMIT, 100)
            }

            val cursor = application.contentResolver.query(
                Uri.parse("content://com.iav.contestdataprovider/text"),
                arrayOf("data"),
               bundle,
                null
            )



            cursor?.let {

                cursor.moveToFirst()


                while (!cursor.isAfterLast) {

                    Log.e("reproducing", cursor.getColumnIndexOrThrow("data").toString())
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