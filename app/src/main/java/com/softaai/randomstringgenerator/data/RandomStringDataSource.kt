package com.softaai.randomstringgenerator.data

import android.app.Application
import android.net.Uri
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

            val cursor = application.contentResolver.query(
                Uri.parse("content://com.iav.contestdataprovider/text"),
                arrayOf("data"),
                null,
                arrayOf(length.toString()),
                null
            )

            cursor?.let {

                cursor.moveToFirst()


                while (!cursor.isAfterLast) {

                    Log.e("reproducing 1", cursor.getColumnIndexOrThrow("data").toString())
                    strBuild.append(
                        """
    
    ${cursor.getString(cursor.getColumnIndexOrThrow("data"))}
    """.trimIndent()
                    )

                    Log.e("reproducing 2", strBuild.toString())
                    cursor.moveToNext()
                }
                cursor.close()
            }

        } catch (e: Exception) {
            emit(
                Resource.Error(
                    message = "Error in Generating Random String"
                )
            )
        }


        emit(Resource.Success(RandomGeneratedString(strBuild.toString())))

    }

}