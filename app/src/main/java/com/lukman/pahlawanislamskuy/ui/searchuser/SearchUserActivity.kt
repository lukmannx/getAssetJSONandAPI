package com.lukman.pahlawanislamskuy.ui.searchuser

import android.content.Intent
import android.nfc.NfcAdapter.EXTRA_DATA
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import com.lukman.pahlawanislamskuy.adapter.UsersAdapter
import com.lukman.pahlawanislamskuy.data.UsersResponse
import com.lukman.pahlawanislamskuy.data.UsersResponseItem
import com.lukman.pahlawanislamskuy.databinding.ActivitySearchUserBinding
import com.lukman.pahlawanislamskuy.ui.DetailActivity
import com.lukman.pahlawanislamskuy.ui.searchrepo.DetailUser

class SearchUserActivity : AppCompatActivity() {

    private var _binding : ActivitySearchUserBinding? = null
    private val binding get() = _binding as ActivitySearchUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySearchUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this)[SearchUserViewModel::class.java]

        binding.svUser.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.searchUser(query.toString())
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

        viewModel.getSearchUser().observe(this) {
            Log.i("DATA", "onCreate: $it \n \n \n Nama usernya ---> ${it.items[0].login}")
            it?.let {
                val adapter = UsersAdapter(it.items)
                adapter.setOnItemClickCallback(object : UsersAdapter.OnItemClickCallback{
                    override fun onItemClicked(item: UsersResponseItem) {
                        startActivity(
                            Intent(this@SearchUserActivity, DetailUser::class.java)
                                .putExtra(DetailUser.EXTRA_DATA, item)
                        )
                    }

                })
                binding.rvUser.adapter = adapter
            }
        }

    }

    fun onItemClicked(item: UsersResponseItem) {
        startActivity(Intent())
    }
}