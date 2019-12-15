package com.atomtray.android.githubdive.searchtabs.RepositoriesTab

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.atomtray.android.githubdive.model.UserRepoListModel
import com.atomtray.android.githubdive.repositories.DataSingleTon

class RepositoryListViewModel : ViewModel() {
    var userRepoListModel = MutableLiveData<List<UserRepoListModel>>()

    fun enableSingleTonObserver(repositoryListFragment: RepositoryListFragment) {
        DataSingleTon.userRepoListData.observe( repositoryListFragment, Observer {
            newUserRepoList ->
            if(newUserRepoList!=null)
            userRepoListModel.value = newUserRepoList
        }
        )


    }

}