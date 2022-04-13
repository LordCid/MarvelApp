package com.example.marvelapp.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.example.marvelapp.R
import com.example.marvelapp.databinding.FragmentCharacterDetailBinding
import com.example.marvelapp.domain.model.MarvelCharacter
import com.example.marvelapp.presentation.common.BaseFragment
import java.util.*
import javax.inject.Inject

const val ARG_CHARACTER_ID = "character_id"

class CharacterDetailFragment : BaseFragment(), CharacterDetailContract.View {

    private var bindingView : FragmentCharacterDetailBinding? = null

    @Inject
    lateinit var presenter: CharacterDetailContract.Presenter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentCharacterDetailBinding.inflate(layoutInflater).let {
        bindingView = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getLong(ARG_CHARACTER_ID)?.apply {
            presenter.getCharacter(this)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        bindingView = null
    }

    override fun showData(character: MarvelCharacter) {
        hideLoadingDialogFragment()
        bindingView?.apply {
            imagesLoader.loadImage(character.thumbnail, header)
            titleTv.text = character.name
            dateTv.text = getDateFormated(character.modified)
            descriptionTv.text = character.description
        }

    }

    override fun showError() {
        hideLoadingDialogFragment()
        bindingView?.apply {
            header.isVisible = false
            descriptionTv.isVisible = false
            errorTv.isVisible = true
        }

    }

    private fun getDateFormated(date: Date?): String {
        return if (date != null) simpleDateFormat.format(date) else ""
    }
}