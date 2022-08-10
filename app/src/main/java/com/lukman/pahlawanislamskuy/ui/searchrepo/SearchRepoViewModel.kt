package com.lukman.pahlawanislamskuy.ui.searchrepo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lukman.pahlawanislamskuy.data.RepoResponse
import com.lukman.pahlawanislamskuy.data.UsersResponse
import com.lukman.pahlawanislamskuy.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchRepoViewModel : ViewModel() {

    val listRepo = MutableLiveData<RepoResponse>()
    fun searchRepo(repoViewString: String) {
        ApiConfig.getApiService().searchRepo(repoViewString).enqueue(object : Callback<RepoResponse> {
            override fun onResponse(call: Call<RepoResponse>, response: Response<RepoResponse>) {
                listRepo.value = response.body()
            }

            override fun onFailure(call: Call<RepoResponse>, t: Throwable) {
                Log.e("RepoUser", "onFailure: $t", )
            }
        })
    }
    fun getSearchRepo() : LiveData<RepoResponse> = listRepo
}