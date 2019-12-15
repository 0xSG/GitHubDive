package com.atomtray.android.githubdive.searchtabs.RepositoriesTab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.atomtray.android.githubdive.R
import com.atomtray.android.githubdive.repositories.DataSingleTon

class RepositoryListFragment : Fragment() {

    private lateinit var repositoryListViewModel: RepositoryListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        repositoryListViewModel =
            ViewModelProviders.of(this).get(RepositoryListViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_repo, container, false)


        repositoryListViewModel.enableSingleTonObserver(this)

        repositoryListViewModel.userRepoListModel.observe(this, Observer { newRepoListModel->
            DataSingleTon.statusText.value = "jjjdjd"
        })


        return root
    }





}