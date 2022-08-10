package com.lukman.pahlawanislamskuy.network

import com.lukman.pahlawanislamskuy.data.RepoResponse
import com.lukman.pahlawanislamskuy.data.UsersResponse
import com.lukman.pahlawanislamskuy.data.UsersResponseItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("users")  // ini endpoint ya deck
    fun getListUsers() : Call<List<UsersResponseItem>> //pake <list karena json bentuk list

    @GET("search/users")
    fun  searchUser(
        @Query("q") username : String  // menambah didalam object
    ) : Call<UsersResponse> // ga pake list karena json bentuk object

    @GET("search/repositories")
    fun searchRepo(@Query ("q") repoName: String) : Call<RepoResponse>
}