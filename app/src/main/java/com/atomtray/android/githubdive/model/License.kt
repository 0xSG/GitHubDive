package com.atomtray.android.githubdive.model


import com.google.gson.annotations.SerializedName

data class License(
    val key: String,
    val name: String,
    @SerializedName("node_id")
    val nodeId: String,
    @SerializedName("spdx_id")
    val spdxId: String,
    val url: String
)