package com.example.marvelapp.presentation.list

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.text.format.DateFormat
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelapp.ARG_CHARACTER_ID
import com.example.marvelapp.R
import com.example.marvelapp.domain.common.ImagesLoader
import com.example.marvelapp.domain.model.MarvelCharacter
import com.example.marvelapp.presentation.detail.CharacterDetailActivity
import dagger.android.DaggerActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class CharacterListActivity : DaggerActivity(), CharacterListContract.View {

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
        showLoadingDialogFragment()
        presenter.getCharacters()
        setOnClickListeters()
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

    private fun showLoadingDialogFragment() {
        progressDialog.setMessage(getString(R.string.downloading_title_dialog))
        progressDialog.show()
    }

    private fun setOnClickListeters(){
        marvelCharactersAdapter.onClickItem = {
            val intent = Intent(this, CharacterDetailActivity::class.java)
            intent.putExtra(ARG_CHARACTER_ID, it)
            startActivity(intent)
        }
    }

    override fun showMarvelCharacters(data: List<MarvelCharacter>) {
        progressDialog.dismiss()
        marvelCharactersAdapter.list = data
    }

    override fun showError() {
        progressDialog.dismiss()
        listView.visibility = GONE
        no_results_tv.visibility = VISIBLE
    }

}