package com.example.marvelapp.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelapp.R
import com.example.marvelapp.domain.common.ImagesLoader
import com.example.marvelapp.domain.model.MarvelCharacter
import java.text.DateFormat
import kotlin.properties.Delegates

class MarvelCharacterAdapter(
    private val imagesLoader: ImagesLoader,
    private val dateFormat: DateFormat
) : RecyclerView.Adapter<ListItemViewHolder>() {

    var list: List<MarvelCharacter> by Delegates.observable(emptyList()) { _, oldValue, newValue ->
        if (oldValue != newValue) {
            notifyDataSetChanged()
        }
    }

    var onClickItem: (Int) -> Unit = {}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListItemViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.item_list, parent, false)
        return ListItemViewHolder(imagesLoader, dateFormat, view, onClickItem)
    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

}

class ListItemViewHolder(
    private val imageLoader: ImagesLoader,
    private val dateFormat: DateFormat,
    itemView: View,
    private val onClick: (Int) -> Unit
) : RecyclerView.ViewHolder(itemView) {

    fun bind(character: MarvelCharacter){
        with(itemView){
            setOnClickListener { onClick(character.id) }
            imageLoader.loadImage(character.thumbnail, group_container)
            title_tv.text = character.name
            date_tv.text = character.modified
            description_short_tv.text = character.description
        }
    }
}
