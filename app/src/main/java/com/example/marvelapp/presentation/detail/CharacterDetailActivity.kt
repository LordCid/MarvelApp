package com.example.marvelapp.presentation.detail

import android.os.Bundle
import android.view.MenuItem
import android.view.View.GONE
import android.view.View.VISIBLE
import com.example.marvelapp.R
import com.example.marvelapp.domain.model.MarvelCharacter
import com.example.marvelapp.presentation.common.BaseActivity
import kotlinx.android.synthetic.main.activity_character_detail.*
import java.util.*
import javax.inject.Inject

const val ARG_CHARACTER_ID = "character_id"

class CharacterDetailActivity : BaseActivity(), CharacterDetailContract.View {

    @Inject
    lateinit var presenter: CharacterDetailContract.Presenter

    private val id: Long by lazy { intent?.extras?.getLong(ARG_CHARACTER_ID) ?: 0L }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_detail)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        presenter.getCharacter(id)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


    override fun showData(character: MarvelCharacter) {
        hideLoadingDialogFragment()
        imagesLoader.loadImage(character.thumbnail, header)
        title_tv.text = character.name
        date_tv.text = getDateFormated(character.modified)
        description_tv.text = character.description
    }

    override fun showError() {
        hideLoadingDialogFragment()
        header.visibility = GONE
        description_tv.visibility = GONE
        error_tv.visibility = VISIBLE
    }

    private fun getDateFormated(date: Date?): String {
        return if (date != null) simpleDateFormat.format(date) else ""
    }
}