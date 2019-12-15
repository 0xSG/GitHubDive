package com.atomtray.android.githubdive.repositories

import com.atomtray.android.githubdive.api.BASE_URL
import com.atomtray.android.githubdive.api.GetUserRepoService
import com.atomtray.android.githubdive.api.GetUserService
import com.atomtray.android.githubdive.model.UserProfile
import com.atomtray.android.githubdive.model.UserRepoListModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkData {


    var userName:String = "0xpulsar"
    fun NetworkData(userName:String){
        this.userName =userName
    }
    init {

        var retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
            GsonConverterFactory.create()
        ).build()


        var detailsservice = retrofit.create(GetUserService::class.java)
        detailsservice.getProfileDetails(userName).enqueue(object : Callback<UserProfile> {
            override fun onFailure(call: Call<UserProfile>, t: Throwable) {

            }
            override fun onResponse(call: Call<UserProfile>, response: Response<UserProfile>) {
                val body = response.body()
                DataSingleTon.isLoadingData.value=false
                DataSingleTon.userProfileData.value = body

            }

        })

        var repoListsservice = retrofit.create(GetUserRepoService::class.java)
        repoListsservice.getRepoList(userName).enqueue(object :
            Callback<List<UserRepoListModel>> {


            override fun onFailure(call: Call<List<UserRepoListModel>>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<List<UserRepoListModel>>,
                response: Response<List<UserRepoListModel>>
            ) {
                val body = response.body()
                DataSingleTon.isLoadingData.value=false
                DataSingleTon.userRepoListData.value = body
            }

        })
    }


}