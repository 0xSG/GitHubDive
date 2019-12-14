package com.atomtray.android.githubdive.api

import com.atomtray.android.githubdive.model.UserProfile
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

var BASE_URL = "https://api.github.com/"

interface GetUserService{
    @GET("users/{userid}")
    fun getProfileDetails(@Path("userid") username:String): Call<UserProfile>

}