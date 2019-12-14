package com.atomtray.android.githubdive.api

import com.atomtray.android.githubdive.model.UserRepoListModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface GetUserRepoService {
    @GET("users/{userid}/repos")
    fun getProfileDetails(@Path("userid") username:String): Call<UserRepoListModel>
}