package com.atomtray.android.githubdive.model
import com.google.gson.annotations.SerializedName

data class UserProfile(
    @SerializedName("avatar_url")
    val avatarUrl: String,
    val bio: String,
    val blog: String,
    val company: Any,
    @SerializedName("created_at")
    val createdAt: String,
    val email: Any,
    @SerializedName("events_url")
    val eventsUrl: String,
    val followers: Int,
    @SerializedName("followers_url")
    val followersUrl: String,
    val following: Int,
    @SerializedName("following_url")
    val followingUrl: String,
    @SerializedName("gists_url")
    val gistsUrl: String,
    @SerializedName("gravatar_id")
    val gravatarId: String,
    val hireable: Boolean,
    @SerializedName("html_url")
    val htmlUrl: String,
    val id: Int,
    val location: String,
    val login: String,
    val name: String,
    @SerializedName("node_id")
    val nodeId: String,
    @SerializedName("organizations_url")
    val organizationsUrl: String,
    @SerializedName("public_gists")
    val publicGists: Int,
    @SerializedName("public_repos")
    val publicRepos: Int,
    @SerializedName("received_events_url")
    val receivedEventsUrl: String,
    @SerializedName("repos_url")
    val reposUrl: String,
    @SerializedName("site_admin")
    val siteAdmin: Boolean,
    @SerializedName("starred_url")
    val starredUrl: String,
    @SerializedName("subscriptions_url")
    val subscriptionsUrl: String,
    val type: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    val url: String
)