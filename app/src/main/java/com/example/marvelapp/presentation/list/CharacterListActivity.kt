package com.example.marvelapp.presentation.list

import android.content.Intent
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelapp.R
import com.example.marvelapp.domain.model.MarvelCharacter
import com.example.marvelapp.presentation.common.BaseActivity
import com.example.marvelapp.presentation.detail.ARG_CHARACTER_ID
import com.example.marvelapp.presentation.detail.CharacterDetailActivity
import kotlinx.android.synthetic.main.activity_character_list.*
import kotlinx.android.synthetic.main.appbar.*
import java.util.*
import javax.inject.Inject

class CharacterListActivity : BaseActivity(), CharacterListContract.View {

    @Inject
    lateinit var presenter: CharacterListContract.Presenter

    private lateinit var marvelCharactersAdapter: MarvelCharacterAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_list)
        setSupportActionBar(findViewById(R.id.toolbar))
        setUpUI()
        presenter.getCharacters()
        setOnClickListeters()
    }

    private fun setUpUI(){
        marvelCharactersAdapter = MarvelCharacterAdapter(imagesLoader, simpleDateFormat)
        listView.apply {
            visibility = VISIBLE
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            this.adapter = marvelCharactersAdapter
        }
        no_results_tv.visibility = GONE
        refresh_btn.apply {
            visibility = VISIBLE
            setOnClickListener { presenter.getCharacters() }
        }
    }



    private fun setOnClickListeters(){
        marvelCharactersAdapter.onClickItem = {
            val intent = Intent(this, CharacterDetailActivity::class.java)
            intent.putExtra(ARG_CHARACTER_ID, it)
            startActivity(intent)
        }
    }

    override fun showMarvelCharacters(data: List<MarvelCharacter>) {
        hideLoadingDialogFragment()
        marvelCharactersAdapter.list = data
    }

    override fun showError() {
        hideLoadingDialogFragment()
        listView.visibility = GONE
        no_results_tv.visibility = VISIBLE
    }


}