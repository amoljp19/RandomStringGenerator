package com.softaai.randomstringgenerator

import android.content.ContentResolver
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.softaai.randomstringgenerator.ui.theme.RandomStringGeneratorTheme

class MainActivity : ComponentActivity() {

    //var CONTENT_URI = Uri.parse("content://com.iav.contestdataprovider/text")

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RandomStringGeneratorTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    innerPadding
                    /*Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )*/

                    ButtonExample {

                        // creating a cursor object of the
                        // content URI
                        val cursor = contentResolver.query(
                            Uri.parse("content://com.iav.contestdataprovider/text"),
                            null,
                            ContentResolver.QUERY_ARG_LIMIT,
                            null,
                            null
                        )

                        // iteration of the cursor
                        // to print whole table
                        if (cursor!!.moveToFirst()) {
                            val strBuild = StringBuilder()
                            while (!cursor.isAfterLast) {
                                strBuild.append(
                                    """
    
    ${cursor.getString(cursor.getColumnIndexOrThrow("data"))}
    """.trimIndent()
                                )
                                cursor.moveToNext()
                            }
                            Log.e("result", strBuild.toString())
                            Toast.makeText(this, " " + strBuild, Toast.LENGTH_SHORT).show()
                        } else {

                            Toast.makeText(this, "No Records Found", Toast.LENGTH_SHORT).show()
                        }
                    }

                }
            }
        }
    }

}

@Composable
fun MainScreen() {
    Text(text = "Show")
}


@Composable
fun ButtonExample(onButtonClick: () -> Unit) {
    Button(
        onClick = onButtonClick,
        contentPadding = PaddingValues(all = 20.dp),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp),
        modifier = Modifier.padding(20.dp)
    ) {
        Text("randome string generate!")
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RandomStringGeneratorTheme {
        Greeting("Android")
    }
}