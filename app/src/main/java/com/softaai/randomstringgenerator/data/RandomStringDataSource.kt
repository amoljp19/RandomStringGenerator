package com.softaai.randomstringgenerator.data

import android.content.ContentResolver
import android.net.Uri
import com.softaai.randomstringgenerator.domain.RandomGeneratedString


/**
 * Created by amoljp19 on 12/20/2024.
 * softAai Apps.
 */
class RandomStringDataSource(private val contentResolver: ContentResolver) {

    suspend fun generateRandomString(length: Int): RandomGeneratedString {

        val cursor = contentResolver.query(
            Uri.parse("content://com.iav.contestdataprovider/text"),
            null,
            ContentResolver.QUERY_ARG_LIMIT,
            null,
            null
        )


        val strBuild = StringBuilder()

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

        return RandomGeneratedString(strBuild.toString())
    }

}