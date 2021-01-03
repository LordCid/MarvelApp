package com.example.marvelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.marvelapp.data.ApiService
import com.example.marvelapp.domain.Utiles
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
        val utiles = Utiles()
        launch {
            runCatching {
                ApiService.create().getCharacterList(
                timeStamp = utiles.getTimeStamp(),
                apikey = PUBLIC_KEY,
                hash = utiles.getHash()
            ).awaitResponse() }.fold(
                    onSuccess = {
                        val resultList = it.body().orEmpty()
                        Result.success(resultList)
                    },
                    onFailure = { }
            )
        }
    }
}