package com.atomtray.android.githubdive.searchtabs.UserDetailsTab

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.atomtray.android.githubdive.model.UserProfile
import com.atomtray.android.githubdive.repositories.DataSingleTon

class UserDetailsViewModel : ViewModel() {



    var profileData:MutableLiveData<UserProfile> = MutableLiveData()


    //Observing the singleTon data
    fun startObservingSingleTon(
        userDetailsFragment: UserDetailsFragment
    ){

        val profileObserver = Observer<UserProfile> { newProfile ->
            profileData.value = newProfile

        }

        DataSingleTon.userProfileData.observe(userDetailsFragment,profileObserver)

    }








}