package com.atomtray.android.githubdive.repositories

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProviders
import com.atomtray.android.githubdive.api.BASE_URL
import com.atomtray.android.githubdive.api.GetUserRepoService
import com.atomtray.android.githubdive.api.GetUserService
import com.atomtray.android.githubdive.databinding.UserDetailsViewModel
import com.atomtray.android.githubdive.model.UserProfile
import com.atomtray.android.githubdive.model.UserRepoListModel
import com.atomtray.android.githubdive.searchtabs.RepositoriesTab.RepositoryListViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object  DataSingleTon{

    operator fun invoke() {

        isLoadingData.value = true
        var retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
            GsonConverterFactory.create()
        ).build()


        var detailsservice = retrofit.create(GetUserService::class.java)
        detailsservice.getProfileDetails(userID.value.toString()).enqueue(object : Callback<UserProfile> {
            override fun onFailure(call: Call<UserProfile>, t: Throwable) {
                isLoadingData.value=false
                statusText.value = "Check your network"
            }
            override fun onResponse(call: Call<UserProfile>, response: Response<UserProfile>) {
                val body = response.body()
                isLoadingData.value=false
                userProfileData.value = body

                if(userProfileData.value?.name?.length == 0 || userProfileData.value?.name?.length == null)
                    statusText.value = "User not found"
                else {
                    statusText.value = "User found"
                }


            }

        })

        var repoListsservice = retrofit.create(GetUserRepoService::class.java)
        repoListsservice.getRepoList(userID.value.toString()).enqueue(object :
            Callback<List<UserRepoListModel>> {

            override fun onFailure(call: Call<List<UserRepoListModel>>, t: Throwable) {
                isLoadingData.value=false
                statusText.value = "Check your network"
            }

            override fun onResponse(
                call: Call<List<UserRepoListModel>>,
                response: Response<List<UserRepoListModel>>
            ) {
                val body = response.body()
                isLoadingData.value=false
                userRepoListData.value = body
                
            }

        })
    }


    fun setID(id:String){
        Log.d("SGK","Single ton called")
        userID.value = id
        invoke()
    }

    var userID = MutableLiveData<String>()
    var userProfileData = MutableLiveData<UserProfile>()
    var userRepoListData = MutableLiveData<List<UserRepoListModel>>()
    var isLoadingData = MutableLiveData<Boolean>()
    var statusText = MutableLiveData<String>()

}