package com.indocyber.assigmentaxa.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.indocyber.assigmentaxa.R
import com.indocyber.assigmentaxa.adapter.PhotoAdapter
import com.indocyber.assigmentaxa.databinding.LayoutPhotoFragmentBinding
import com.indocyber.assigmentaxa.view_model.PhotoViewModel
import com.indocyber.common.base.AppResponse
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotoFragment : Fragment() {
    val vm: PhotoViewModel by viewModels()
    val layoutResourceId: Int = R.layout.layout_photo_fragment
    lateinit var binding: LayoutPhotoFragmentBinding
    val adapter = PhotoAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<LayoutPhotoFragmentBinding>(
            inflater,
            layoutResourceId,
            container,
            false
        )
        binding.lifecycleOwner = viewLifecycleOwner
        binding.photoRecycler.adapter = adapter
        binding.search.addTextChangedListener {
            val data = vm.filter(it.toString())
            adapter.listItem.submitList(data)
        }
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm.photoData.observe(this) {
            when (it) {
                is AppResponse.AppResponseSuccess -> {
                    adapter.sendData(it.data)
                }
            }
        }
    }

}