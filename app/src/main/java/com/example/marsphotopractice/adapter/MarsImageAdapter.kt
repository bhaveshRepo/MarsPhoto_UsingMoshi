package com.example.marsphotopractice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marsphotopractice.R
import com.example.marsphotopractice.model.MarsPhoto
import kotlinx.android.synthetic.main.gird_view_item.view.*

class MarsImageAdapter : RecyclerView.Adapter<MarsImageAdapter.MarsViewHolder>() {

    private val diffCallBack = object : DiffUtil.ItemCallback<MarsPhoto>(){
        override fun areItemsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MarsPhoto, newItem: MarsPhoto): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this, diffCallBack)


    inner class MarsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsViewHolder {
        val layoutAdapter = LayoutInflater.from(parent.context).inflate(R.layout.gird_view_item,
        parent,false)
        return MarsViewHolder(layoutAdapter)
    }

    override fun onBindViewHolder(holder: MarsViewHolder, position: Int) {
        val imageItem = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(imageItem.img_url.toUri()
                .buildUpon().scheme("https").build()).into(mars_image)
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}