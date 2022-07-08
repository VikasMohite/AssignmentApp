package com.example.turtlemintassignment

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("repos/square/okhttp/issues")
    fun getIssues(): Call<List<IssuesResponseModel>>

    @GET("{commentId}/comments")
    fun getComments(@Path("commentId") commentId: String): Call<List<IssuesResponseModel>>
}