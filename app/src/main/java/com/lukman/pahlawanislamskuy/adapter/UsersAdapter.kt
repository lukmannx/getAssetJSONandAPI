package com.lukman.pahlawanislamskuy.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lukman.pahlawanislamskuy.data.Pahlawan
import com.lukman.pahlawanislamskuy.data.UsersResponse
import com.lukman.pahlawanislamskuy.data.UsersResponseItem
import com.lukman.pahlawanislamskuy.databinding.RowItemUserBinding
import com.squareup.picasso.Picasso

class UsersAdapter(private val listUsers: List<UsersResponseItem>) :
    RecyclerView.Adapter<UsersAdapter.MyViewHolder>() {

    interface OnItemClickCallback {

        fun onItemClicked(item: UsersResponseItem)
    }

    private var onItemClickCallback: OnItemClickCallback? = null

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,

        ) =
        MyViewHolder(RowItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    class MyViewHolder(val binding: RowItemUserBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = listUsers[position]
        holder.binding.apply {
            tvNamaUser.text = listUsers[position].login
            tvIdUser.text = listUsers[position].id.toString()
            Picasso.get().load(listUsers[position].avatarUrl).into(imgUser);

            holder.itemView.setOnClickListener {
                onItemClickCallback?.onItemClicked(data)
            }
        }
    }

    override fun getItemCount() = listUsers.size
}