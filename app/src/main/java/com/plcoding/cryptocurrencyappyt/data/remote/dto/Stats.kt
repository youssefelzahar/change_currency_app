package com.plcoding.cryptocurrencyappyt.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Stats(
    @SerializedName("contributors")
    val contributors: Int, // 1094
    @SerializedName("followers")
    val followers: Int, // 160521
    @SerializedName("stars")
    val stars: Int, // 66619
    @SerializedName("subscribers")
    val subscribers: Int // 4653779
)