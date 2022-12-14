package com.lukman.pahlawanislamskuy.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.lukman.pahlawanislamskuy.R
import com.lukman.pahlawanislamskuy.databinding.ActivityMainBinding
import com.lukman.pahlawanislamskuy.ui.listuser.ListUserActivity
import com.lukman.pahlawanislamskuy.ui.pahlawanlocal.JsonActivity
import com.lukman.pahlawanislamskuy.ui.searchuser.SearchUserActivity

class MainActivity : AppCompatActivity(), View.OnClickListener{

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnDisplayJson.setOnClickListener(this@MainActivity)
            btnDisplayUser.setOnClickListener(this@MainActivity)
            btnDisplayUserSearch.setOnClickListener(this@MainActivity)
            btnRepo.setOnClickListener(this@MainActivity)
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btnDisplayJson -> startActivity(Intent(this, JsonActivity::class.java))
            R.id.btnDisplayUser -> startActivity(Intent(this, ListUserActivity::class.java))
            R.id.btnDisplayUserSearch -> startActivity(Intent(this, SearchUserActivity::class.java))
            R.id.btnRepo -> startActivity(Intent(this, JsonActivity::class.java))
        }
    }
}