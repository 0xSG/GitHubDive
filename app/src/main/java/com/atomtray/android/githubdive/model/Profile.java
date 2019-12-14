package com.atomtray.android.githubdive.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


class Profile {


    @SerializedName("login")
    @Expose
    private String login;

    @SerializedName("avatar_url")
    @Expose
    private String avatarURL;

    @SerializedName("html_url")
    @Expose
    private String htmlURL;


}