package com.atomtray.android.githubdive.searchtabs.UserDetailsTab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.accessibility.AccessibilityManager
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.atomtray.android.githubdive.R
import com.atomtray.android.githubdive.model.UserProfile
import com.bumptech.glide.Glide

class UserDetailsFragment : Fragment() {

    private lateinit var userDetailsViewModel: UserDetailsViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        userDetailsViewModel =
            ViewModelProviders.of(this).get(UserDetailsViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_details, container, false)





        val profileDataObserver = Observer<UserProfile> { newProfileData ->
            if(root != null && newProfileData != null) {
                root.findViewById<TextView>(R.id.nameTxt).text = newProfileData.name

                root.findViewById<TextView>(R.id.bioTxt).text = newProfileData.bio

                Glide.with(root.findViewById<ImageView>(R.id.dp).context)
                    .load(newProfileData.avatarUrl).into(root.findViewById<ImageView>(R.id.dp))

                root.findViewById<TextView>(R.id.repoTxt).text = newProfileData.id.toString()

            }
        }

        userDetailsViewModel.startObservingSingleTon(this)

        userDetailsViewModel.profileData.observe(this,profileDataObserver)


        return root
    }
}