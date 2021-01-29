package com.example.marvelapp.presentation

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelapp.PUBLIC_KEY
import com.example.marvelapp.R
import com.example.marvelapp.data.ApiService
import com.example.marvelapp.domain.UtilitiesImpl
import com.example.marvelapp.domain.common.ImagesLoader
import com.example.marvelapp.domain.model.MarvelCharacter
import dagger.android.DaggerActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import retrofit2.awaitResponse
import javax.inject.Inject

class CharacterListActivity : DaggerActivity(), CharacterListContract.View{

    @Inject
    lateinit var imagesLoader: ImagesLoader

    @Inject
    lateinit var presenter: CharacterListContract.Presenter

    private lateinit var progressDialog: ProgressDialog

    private lateinit var marvelCharactersAdapter: MarvelCharacterAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpUI()
        presenter.getCharacters()
    }

    private fun setUpUI(){
        val dateFormat = DateFormat.getDateFormat(this)
        marvelCharactersAdapter = MarvelCharacterAdapter(imagesLoader, dateFormat)
        progressDialog = ProgressDialog(this)
        listView.apply {
            visibility = VISIBLE
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            this.adapter = marvelCharactersAdapter
        }
        no_results_tv.visibility = GONE
    }


    override fun showMarvelCharacters(data: List<MarvelCharacter>) {
        marvelCharactersAdapter.list = data
    }

    override fun showError() {
        listView.visibility = GONE
        no_results_tv.visibility = VISIBLE
    }
    
}