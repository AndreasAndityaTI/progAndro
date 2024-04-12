package com.FastMenu.app.view.search

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.FastMenu.app.data.response.MakananItem
import com.FastMenu.app.view.detail.DetailMakananActivity
import com.FastMenu.app.databinding.ItemTopengBinding


class MakananAdapter : ListAdapter<MakananItem, MakananAdapter.MyViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemTopengBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user = getItem(position)
        holder.bind(user)

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailMakananActivity::class.java)
            intentDetail.putExtra(DetailMakananActivity.EXTRA_ID, user.id.toString())
            holder.itemView.context.startActivity(intentDetail)
        }
    }

    class MyViewHolder(private val binding: ItemTopengBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(user: MakananItem) {
            binding.tvNamaTopeng.text = user.name
            Glide.with(binding.root).load(user.imageUrl).into(binding.ivItemPhoto)
            binding.tvDeskripsiTopeng.text = user.informasi
        }
    }


    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MakananItem>(){
            override fun areItemsTheSame(oldItem: MakananItem, newItem: MakananItem): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: MakananItem, newItem: MakananItem): Boolean {
                return oldItem == newItem
            }
        }
    }



}