package com.lukman.pahlawanislamskuy.ui.searchuser

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lukman.pahlawanislamskuy.data.UsersResponse
import com.lukman.pahlawanislamskuy.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchUserViewModel : ViewModel() {

    val listUser = MutableLiveData<UsersResponse>()

    fun searchUser(searchViewString: String) {
        ApiConfig.getApiService().searchUser(searchViewString).enqueue(object : Callback<UsersResponse> {
            override fun onResponse(call: Call<UsersResponse>, response: Response<UsersResponse>) {
                listUser.value = response.body()
            }

            override fun onFailure(call: Call<UsersResponse>, t: Throwable) {
                Log.e("SearchUser", "onFailure: $t", )
            }
        })
    }

    fun getSearchUser() : LiveData<UsersResponse> = listUser
}