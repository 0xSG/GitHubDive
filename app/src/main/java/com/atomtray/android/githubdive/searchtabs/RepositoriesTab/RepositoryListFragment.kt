package com.atomtray.android.githubdive.searchtabs.RepositoriesTab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.atomtray.android.githubdive.R
import com.atomtray.android.githubdive.api.BASE_URL

import com.atomtray.android.githubdive.api.GetUserService
import com.atomtray.android.githubdive.model.UserProfile
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

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





        return root
    }





}