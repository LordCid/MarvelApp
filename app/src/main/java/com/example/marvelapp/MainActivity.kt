package com.example.marvelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.marvelapp.data.ApiService
import com.example.marvelapp.domain.UtilitiesImpl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import retrofit2.awaitResponse

class MainActivity : AppCompatActivity(), CoroutineScope by MainScope() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        testApi()
    }

    private fun testApi(){
        val utiles = UtilitiesImpl()
        launch {
            val result = runCatching {
                ApiService.create().getCharacterList(
                timeStamp = utiles.getTimeStamp(),
                apikey = PUBLIC_KEY,
                hash = utiles.getHash()
            ).awaitResponse() }.fold(
                onSuccess = {
                    Log.d("MARVEL", it.toString())
                },
                onFailure = {
                    Log.e("MARVEL", it.message ?:"")
                }
            )
            Log.d("MARVEL", result.toString())

        }

    }
}