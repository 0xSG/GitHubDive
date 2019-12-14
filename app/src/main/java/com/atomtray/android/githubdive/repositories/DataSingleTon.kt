package com.atomtray.android.githubdive.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.atomtray.android.githubdive.model.UserProfile
import com.atomtray.android.githubdive.model.UserRepoListModel

object  DataSingleTon{
    var userProfile:UserProfile? = null
    var userRepoListModel:UserRepoListModel? = null
    var isLoading:Boolean = false

    private val _userprofileData = MutableLiveData<UserProfile>()
    val userprofileData:LiveData<UserProfile>
        get() = _userprofileData

    private val _userRepoListData = MutableLiveData<UserRepoListModel>()
    val userRepoListData:LiveData<UserRepoListModel>
        get() = _userRepoListData

    private val _isLoadingData = MutableLiveData<Boolean>()
    val isLoadingData:LiveData<Boolean>
        get() = _isLoadingData



}