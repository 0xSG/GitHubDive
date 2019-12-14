package com.atomtray.android.githubdive.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
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

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_home, container, false)


        //TODO: Search using API and Show

        var retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
            GsonConverterFactory.create()
        ).build()

        var service = retrofit.create(GetUserService::class.java)
         service.getProfileDetails("0xpulsar").enqueue(object :Callback<UserProfile>{
            override fun onFailure(call: Call<UserProfile>, t: Throwable) {
                Toast.makeText(context,"dd",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<UserProfile>, response: Response<UserProfile>) {

                val body = response.body()

                Toast.makeText(context,body?.name,Toast.LENGTH_LONG).show()


            }

        })




        return root
    }





}