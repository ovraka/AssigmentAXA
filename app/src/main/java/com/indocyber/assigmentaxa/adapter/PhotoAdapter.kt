package com.indocyber.assigmentaxa.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.indocyber.assigmentaxa.databinding.LayoutPhotoItemBinding
import com.indocyber.common.data_class.PhotoResponseItem
import com.indocyber.common.ext.Constants.loadImageFromUrl

class PhotoAdapter() : RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>() {

    val listItem = AsyncListDiffer<PhotoResponseItem>(this, differ)

    inner class PhotoViewHolder(val binding: LayoutPhotoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(photoResponseItem: PhotoResponseItem) {
            binding.thumbnailPhoto.loadImageFromUrl(photoResponseItem.thumbnailUrl)
            binding.title.text = photoResponseItem.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder =
        PhotoViewHolder(
            LayoutPhotoItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(listItem.currentList[position])
    }

    override fun getItemCount(): Int {
        return listItem.currentList.size
    }

    fun sendData(photoItem: List<PhotoResponseItem>) {
        listItem.submitList(photoItem)
    }

    companion object {
        val differ = object : DiffUtil.ItemCallback<PhotoResponseItem>() {
            override fun areItemsTheSame(
                oldItem: PhotoResponseItem,
                newItem: PhotoResponseItem
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: PhotoResponseItem,
                newItem: PhotoResponseItem
            ): Boolean {
                return oldItem == newItem
            }

        }
    }
}