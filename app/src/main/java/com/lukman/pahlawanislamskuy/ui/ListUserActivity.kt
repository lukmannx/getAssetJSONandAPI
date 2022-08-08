package com.lukman.pahlawanislamskuy.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.lukman.pahlawanislamskuy.R
import com.lukman.pahlawanislamskuy.ui.listuser.ListUserViewModel

class ListUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_user)

        val viewModel = ViewModelProvider(this)[ListUserViewModel::class.java]
        viewModel.listUser()
        viewModel.getResultListUser().observe(this) {
            Log.i("ListUser", "onCreate: $it")
        }
    }
}