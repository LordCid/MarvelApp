package com.example.marvelapp.presentation.detail

import android.os.Bundle
import com.example.marvelapp.R
import dagger.android.DaggerActivity

class CharacterDetailActivity : DaggerActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_detail)

    }
}