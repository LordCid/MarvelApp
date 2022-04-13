package com.example.marvelapp.presentation.list

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelapp.R
import com.example.marvelapp.databinding.FragmentCharacterListBinding
import com.example.marvelapp.domain.model.MarvelCharacter
import com.example.marvelapp.presentation.common.BaseFragment
import com.example.marvelapp.presentation.detail.ARG_CHARACTER_ID
import javax.inject.Inject

class CharacterListFragment : BaseFragment(), CharacterListContract.View {

    private var bindingView : FragmentCharacterListBinding? = null

    @Inject
    lateinit var presenter: CharacterListContract.Presenter

    private lateinit var marvelCharactersAdapter: MarvelCharacterAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentCharacterListBinding.inflate(layoutInflater).let {
        bindingView = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpUI()
        presenter.getCharacters()
        setOnClickListeners()

    }

    private fun setUpUI(){
        marvelCharactersAdapter = MarvelCharacterAdapter(imagesLoader, simpleDateFormat)
        bindingView?.apply {
            listView.apply {
                isVisible = true
                layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
                this.adapter = marvelCharactersAdapter
            }
            noResultsTv.isVisible = false
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        bindingView = null
        presenter.onDestroy()
    }

    private fun setOnClickListeners(){
        marvelCharactersAdapter.onClickItem = {
            findNavController().navigate(
                R.id.action_go_to_detail,
                Bundle().apply {
                    putLong(ARG_CHARACTER_ID, it)
                }
            )
        }
    }

    override fun showMarvelCharacters(data: List<MarvelCharacter>) {
        hideLoadingDialogFragment()
        marvelCharactersAdapter.list = data
    }

    override fun showError() {
        hideLoadingDialogFragment()
        bindingView?.apply {
            listView.isVisible = false
            noResultsTv.isVisible = true
        }
    }


}