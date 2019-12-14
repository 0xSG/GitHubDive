package com.atomtray.android.githubdive.api;


import android.provider.ContactsContract;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Service {
    @GET("/search/users?q=tom")
    Call<ContactsContract.Profile> getItems();
}
