package com.atomtray.android.githubdive.searchtabs.UserDetailsTab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.atomtray.android.githubdive.R
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

        val nameObserver = Observer<String> { newName ->
            // Update the UI, in this case, a TextView.
            root.findViewById<TextView>(R.id.nameTxt).text = newName
        }
        val bioTxtObserver = Observer<String> { newbioTxt ->
            // Update the UI, in this case, a TextView.
            root.findViewById<TextView>(R.id.bioTxt).text = newbioTxt
        }
        val profileUrlObserver = Observer<String> { newProfileUrl ->
            Glide.with(root.findViewById<ImageView>(R.id.dp).context).load(newProfileUrl).into(root.findViewById<ImageView>(R.id.dp))
        }
        val repoTxtObserver = Observer<String> { newrepoTxt ->
            // Update the UI, in this case, a TextView.
            root.findViewById<TextView>(R.id.repoTxt).text = newrepoTxt
        }


        userDetailsViewModel.getValuesN("0xpulsar",this)
        userDetailsViewModel.name.observe(this,nameObserver)
        userDetailsViewModel.bio.observe(this,bioTxtObserver)
        userDetailsViewModel.profileUrl.observe(this,profileUrlObserver)
        userDetailsViewModel.numRepo.observe(this,repoTxtObserver)


        return root
    }
}