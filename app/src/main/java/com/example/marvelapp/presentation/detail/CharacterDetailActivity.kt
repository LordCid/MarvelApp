package com.example.marvelapp.presentation.detail

import android.app.ProgressDialog
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.app.AppCompatActivity
import com.example.marvelapp.ARG_CHARACTER_ID
import com.example.marvelapp.R
import com.example.marvelapp.domain.common.ImagesLoader
import com.example.marvelapp.domain.model.MarvelCharacter
import dagger.android.AndroidInjection
import dagger.android.DaggerActivity
import kotlinx.android.synthetic.main.activity_character_detail.*
import javax.inject.Inject

class CharacterDetailActivity : AppCompatActivity(), CharacterDetailContract.View {

    private lateinit var progressDialog: ProgressDialog

    @Inject
    lateinit var presenter: CharacterDetailContract.Presenter

    @Inject
    lateinit var imagesLoader: ImagesLoader

    private val id: Long by lazy { intent?.extras?.getLong(ARG_CHARACTER_ID) ?:0L }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_character_detail)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        progressDialog = ProgressDialog(this)
        showLoadingDialogFragment()
        presenter.getCharacter(id)

    }

    private fun showLoadingDialogFragment() {
        progressDialog.setMessage(getString(R.string.downloading_title_dialog))
        progressDialog.show()
    }

    override fun showData(character: MarvelCharacter) {
        progressDialog.dismiss()
        imagesLoader.loadImage(character.thumbnail, header)
        title_tv.text = character.name
        date_tv.text = character.modified
        description_tv.text = character.description
    }

    override fun showError() {
        progressDialog.dismiss()
        header.visibility = GONE
        description_tv.visibility = GONE
        error_tv.visibility = VISIBLE
    }
}