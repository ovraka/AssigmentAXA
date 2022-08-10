package com.indocyber.assigmentaxa.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.indocyber.assigmentaxa.R
import com.indocyber.assigmentaxa.databinding.LayoutPhotoFragmentBinding
import com.indocyber.assigmentaxa.view_model.PhotoViewModel

class PhotoFragment: Fragment() {
    val vm : PhotoViewModel by viewModels()
    val layoutResourceId : Int = R.layout.layout_photo_fragment
    lateinit var binding : LayoutPhotoFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}