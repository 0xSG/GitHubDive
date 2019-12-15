package com.atomtray.android.githubdive.searchtabs.UserDetailsTab

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.atomtray.android.githubdive.model.UserProfile
import com.atomtray.android.githubdive.repositories.DataSingleTon

class UserDetailsViewModel : ViewModel() {

    var name: MutableLiveData<String> = MutableLiveData()
    var numRepo:  MutableLiveData<String> = MutableLiveData()
    var bio: MutableLiveData<String> = MutableLiveData()
    var profileUrl: MutableLiveData<String> = MutableLiveData()


    fun getValuesN(
        idInp: String,
        userDetailsFragment: UserDetailsFragment
    ){


        DataSingleTon.setID(idInp)

        val profileObserver = Observer<UserProfile> { newProfile ->
            name.value = newProfile.name
            numRepo.value = newProfile.id.toString()
            bio.value = newProfile.bio
            profileUrl.value = newProfile?.avatarUrl
        }

        DataSingleTon.userProfileData.observe(userDetailsFragment,profileObserver)

    }








}