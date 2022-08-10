package com.lukman.pahlawanislamskuy.ui.listuser

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lukman.pahlawanislamskuy.data.UsersResponseItem
import com.lukman.pahlawanislamskuy.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListUserViewModel : ViewModel() {

    private val listUser = MutableLiveData<List<UsersResponseItem>>()

    fun listUser() {
        ApiConfig.getApiService().getListUsers().enqueue(object : Callback<List<UsersResponseItem>> {
            override fun onResponse(
                call: Call<List<UsersResponseItem>>,
                // data sudah berada di parameter response ketika fungsi getListUser() dipakai
                response: Response<List<UsersResponseItem>>
            ) {
                // mengisi listUser yang masih kosong dengan data response
                listUser.value = response.body()
//                listUser.postValue(response.body())
            }

            override fun onFailure(call: Call<List<UsersResponseItem>>, t: Throwable) {
                Log.e("TAG", "onFailure: $t", )
            }

        })
    }

    // fungsi yang bertugas menyediakan data untuk ditampilkan/ di observe di UI Controller
    fun getResultListUser() : LiveData<List<UsersResponseItem>> = listUser
}