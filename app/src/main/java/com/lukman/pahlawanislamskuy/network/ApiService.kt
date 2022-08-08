package com.lukman.pahlawanislamskuy.network

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
}