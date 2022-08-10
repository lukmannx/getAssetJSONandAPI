package com.lukman.pahlawanislamskuy.data

import com.google.gson.annotations.SerializedName

data class RepoResponse (
    @field:SerializedName("item")
    val item: List<RepoItem>? = null
)

data class RepoItem (
    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("full_name")
    val fullName: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("topics")
    val topics: List<String>
)
