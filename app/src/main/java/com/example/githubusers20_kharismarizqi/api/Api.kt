package com.example.githubusers20_kharismarizqi.api

import com.example.githubusers20_kharismarizqi.ui.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.HEAD
import retrofit2.http.Headers
import retrofit2.http.Query

interface Api {
    @GET("search/users")
    @Headers("Authorization: token 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")
    fun getSearchUsers(
        @Query("q") query: String
    ): Call<UserResponse>
}