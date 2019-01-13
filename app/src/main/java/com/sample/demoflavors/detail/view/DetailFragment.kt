package com.sample.demoflavors.detail.view


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sample.demoflavors.R
import com.sample.demoflavors.api.models.CharacterModel
import kotlinx.android.synthetic.main.fragment_detail.view.*

const val ARG_CHARACTER = "ARG_CHARACTER"
const val ARG_SHOW_TITLE_FLAG = "ARG_SHOW_TITLE_FLAG"

class DetailFragment : Fragment(), DetailBase {

    override var character: CharacterModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            if (it.containsKey(ARG_CHARACTER)) {
                character = it.getSerializable(ARG_CHARACTER) as CharacterModel
            }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_detail, container, false)

        setupView(rootView.description_view, rootView.image_view)

        return rootView
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: CharacterModel, param2: Boolean = true) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(ARG_CHARACTER, param1)
                    putBoolean(ARG_SHOW_TITLE_FLAG, param2)
                }
            }
    }
}
