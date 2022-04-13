package com.example.marvelapp.presentation.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelapp.R
import com.example.marvelapp.databinding.ItemListBinding
import com.example.marvelapp.domain.common.ImagesLoader
import com.example.marvelapp.domain.model.MarvelCharacter
import kotlinx.android.synthetic.main.item_list.view.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.properties.Delegates

class MarvelCharacterAdapter(
    private val imagesLoader: ImagesLoader,
    private val dateFormat: SimpleDateFormat
) : RecyclerView.Adapter<ListItemViewHolder>() {

    var list: List<MarvelCharacter> by Delegates.observable(emptyList()) { _, oldValue, newValue ->
        if (oldValue != newValue) {
            notifyDataSetChanged()
        }
    }

    var onClickItem: (Long) -> Unit = {}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val bindingView = ItemListBinding.inflate(inflater, parent, false)
        return ListItemViewHolder(imagesLoader, dateFormat, bindingView, onClickItem)
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

}

class ListItemViewHolder(
    private val imageLoader: ImagesLoader,
    private val dateFormat: SimpleDateFormat,
    private val bindingView: ItemListBinding,
    private val onClick: (Long) -> Unit
) : RecyclerView.ViewHolder(bindingView.root) {

    fun bind(character: MarvelCharacter) {
        with(bindingView) {
            root.setOnClickListener { onClick(character.id) }
            imageLoader.loadImage(character.thumbnail, characterContainer)
            titleTv.text = character.name
            dateTv.text = getDateFormated(character.modified)
        }
    }

    private fun getDateFormated(date: Date?): String {
        return if (date != null) dateFormat.format(date) else ""
    }
}
