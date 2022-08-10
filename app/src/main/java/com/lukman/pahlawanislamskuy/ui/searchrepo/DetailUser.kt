package com.lukman.pahlawanislamskuy.ui.searchrepo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lukman.pahlawanislamskuy.databinding.ActivityDetailUserBinding

class DetailUser : AppCompatActivity() {

    private var _binding : ActivityDetailUserBinding? = null
    private val binding get() = _binding as ActivityDetailUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}