package com.atomtray.android.githubdive.searchtabs.RepositoriesTab

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RepositoryListViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Repository list"
    }
    val text: LiveData<String> = _text
}