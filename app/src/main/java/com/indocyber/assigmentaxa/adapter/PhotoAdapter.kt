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

    val photoData = AsyncListDiffer<PhotoResponseItem>(this, differ)

    inner class PhotoViewHolder(val binding: LayoutPhotoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: PhotoResponseItem) {
            binding.tumbnailPhoto.loadImageFromUrl(data.thumbnailUrl)
            binding.title.text = data.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(
            LayoutPhotoItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(photoData.currentList[position])
    }

    override fun getItemCount(): Int {
        return photoData.currentList.size
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