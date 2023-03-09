package com.geektech.android3dz1mvvm.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.geektech.android3dz1mvvm.databinding.ItemBookBinding
import com.geektech.android3dz1mvvm.model.ModelBook

class BookAdapter(private var listBook: MutableList<ModelBook>,
                  val onItemClick:(modelBook: ModelBook) ->Unit)
    : RecyclerView.Adapter<BookAdapter.AdapterViewHolder>() {

    @SuppressLint("NotifyDataSetChanged")
    fun setupObserves(listBook: MutableList<ModelBook>){
        this.listBook = listBook
        notifyDataSetChanged()
    }

    inner class AdapterViewHolder( var binding: ItemBookBinding)
        :RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener{
                onItemClick(listBook[adapterPosition])
            }
        }

        fun onBind (modelBook: ModelBook){
            binding.txtName.text = modelBook.name
            Glide.with(binding.ivImage.context).load(modelBook.image).into(binding.ivImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        return AdapterViewHolder(ItemBookBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        holder.onBind(listBook[position])
    }

    override fun getItemCount(): Int = listBook.size

}