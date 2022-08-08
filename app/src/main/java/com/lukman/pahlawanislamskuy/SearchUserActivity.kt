package com.lukman.pahlawanislamskuy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.lukman.pahlawanislamskuy.ui.listuser.SearchUserViewModel

class SearchUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_user)

        val searchViewString = "Andi"

        val viewModel = ViewModelProvider(this)[SearchUserViewModel::class.java]
        viewModel.searchUser(searchViewString)
        viewModel.getSearchUser().observe(this) {
            Log.i("DATA", "onCreate: $it \n \n \n Nama usernya ---> ${it.items[0].login}")
            println(it.items?.get(0)?.login)
        }
    }
}