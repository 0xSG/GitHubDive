package com.atomtray.android.githubdive.searchtabs.UserDetailsTab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.atomtray.android.githubdive.R

class UserDetailsFragment : Fragment() {

    private lateinit var userDetailsViewModel: UserDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        userDetailsViewModel =
            ViewModelProviders.of(this).get(UserDetailsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)


        //TODO: Search using API and Show

        userDetailsViewModel.text.observe(this, Observer {

        })
        return root
    }
}