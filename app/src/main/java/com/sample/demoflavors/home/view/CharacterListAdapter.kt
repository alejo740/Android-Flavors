package com.sample.demoflavors.home.view

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.sample.demoflavors.R
import com.sample.demoflavors.api.models.CharacterModel
import kotlinx.android.synthetic.main.grid_character_item.view.*
import kotlinx.android.synthetic.main.linear_character_item.view.*

class CharacterListAdapter(val clickListener: (CharacterModel, View) -> Unit) :
    RecyclerView.Adapter<CharacterListAdapter.CharacterViewHolder>() {

    companion object {
        val imageOptions = RequestOptions()
            .placeholder(R.drawable.ic_placeholder)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
    }

    var items: ArrayList<CharacterModel> = ArrayList()
    var linearView: Boolean = true

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CharacterViewHolder {
        val layoutId = if(linearView) R.layout.linear_character_item else R.layout.grid_character_item
        val layout = LayoutInflater.from(p0.context).inflate(layoutId, p0, false)
        return CharacterViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(p0: CharacterViewHolder, p1: Int) {
        Log.i("FLAV", "CREATE...")
        p0.bind(items[p1], clickListener)
    }

    fun addCharacter(characterModel: CharacterModel) {
        items.add(characterModel)
        notifyItemInserted(items.size - 1)
    }

    fun clearItems() {
        items.clear()
        notifyDataSetChanged()
    }

    fun setCharacters(characters: List<CharacterModel>) {
        items.clear()
        items.addAll(characters)
        notifyDataSetChanged()
    }

    class CharacterViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        private var title = view.title_text
        private var image = view.image_view

        fun bind(character: CharacterModel, clickListener: (CharacterModel, View) -> Unit) {

            title?.let { it.text = character.title}

            image?.let {
                Glide.with(image.context)
                    .load(character.photoUrl)
                    .apply(imageOptions)
                    .into(image)
            }

            view.setOnClickListener {
                clickListener(character, view)
            }
        }
    }
}