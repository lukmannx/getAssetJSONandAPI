package com.lukman.pahlawanislamskuy.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lukman.pahlawanislamskuy.data.Pahlawan
import com.lukman.pahlawanislamskuy.databinding.RowItemPahlawanBinding
import com.squareup.picasso.Picasso

class PahlawanAdapter : RecyclerView.Adapter<PahlawanAdapter.MyViewHolder>() {

    private var listPahlawan = ArrayList<Pahlawan>()

    fun setData(list: List<Pahlawan>?) {
        if (list == null) return
        listPahlawan.clear()
        listPahlawan.addAll(list)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int

    ) = MyViewHolder(RowItemPahlawanBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    class MyViewHolder(val binding: RowItemPahlawanBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.apply {
            tvNama.text = listPahlawan[position].nama
            Picasso.get().load(listPahlawan[position].gambar).into(imgReview);
        }
    }

    override fun getItemCount() = listPahlawan.size
}