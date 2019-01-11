package com.sample.demoflavors.home.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sample.demoflavors.R
import com.sample.demoflavors.api.models.CharacterModel

class CharacterListAdapter(val clickListener: (CharacterModel) -> Unit) :
    RecyclerView.Adapter<CharacterListAdapter.CharacterViewHolder>() {

    var items: ArrayList<CharacterModel> = ArrayList()

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CharacterViewHolder {
        val layout = LayoutInflater.from(p0.context).inflate(R.layout.linear_character_item, p0, false)
        return CharacterViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(p0: CharacterViewHolder, p1: Int) {
        p0.bind(items[p1], clickListener)
    }

    fun addCharacter(characterModel: CharacterModel) {
        items.add(characterModel)
        notifyItemInserted(items.size - 1)
    }

    fun setCharacters(characters: List<CharacterModel>) {
        items.clear()
        items.addAll(characters)
        notifyDataSetChanged()
    }

    class CharacterViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(character: CharacterModel, clickListener: (CharacterModel) -> Unit) {
            view.setOnClickListener {
                clickListener(character)
            }
        }
    }
}