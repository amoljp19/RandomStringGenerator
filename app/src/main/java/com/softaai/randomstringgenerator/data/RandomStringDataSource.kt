package com.softaai.randomstringgenerator.data

import android.app.Application
import android.content.UriMatcher
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

            val sUriMatcher = UriMatcher(UriMatcher.NO_MATCH)

            val type: String? = application.contentResolver.getType(Uri.parse("content://com.iav.contestdataprovider/text"))

            Log.e("reproducing Type", type.toString())   // type also returning same mime type that is vnd.android.cursor.dir/text


            val cursor = application.contentResolver.query(
                Uri.parse("content://com.iav.contestdataprovider/text"),
                arrayOf("data") ,
                "data = ?",
                arrayOf(length.toString()),
                null
            )


            cursor?.let {

                Log.e("reproducing cursor count : ", cursor.count.toString())

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