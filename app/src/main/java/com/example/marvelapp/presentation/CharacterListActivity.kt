package com.example.marvelapp.presentation

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.marvelapp.PUBLIC_KEY
import com.example.marvelapp.R
import com.example.marvelapp.data.ApiService
import com.example.marvelapp.domain.UtilitiesImpl
import com.example.marvelapp.domain.model.MarvelCharacter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import retrofit2.awaitResponse

class CharacterListActivity : AppCompatActivity(), CharacterListContract.View{

    private lateinit var progressDialog: ProgressDialog

    private lateinit var marvelCharactersAdapter: MarvelCharacterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun showMarvelCharacters(data: List<MarvelCharacter>) {

    }

    override fun showError() {
        TODO("Not yet implemented")
    }

//    private fun testApi(){
//        val utiles = UtilitiesImpl()
//        launch {
//            val result = runCatching {
//                ApiService.create().getCharacterList(
//                timeStamp = utiles.getTimeStamp(),
//                apikey = PUBLIC_KEY,
//                hash = utiles.getHash()
//            ).awaitResponse() }.fold(
//                onSuccess = {
//                    Log.d("MARVEL", it.toString())
//                },
//                onFailure = {
//                    Log.e("MARVEL", it.message ?:"")
//                }
//            )
//            Log.d("MARVEL", result.toString())
//
//        }
//
//    }
}