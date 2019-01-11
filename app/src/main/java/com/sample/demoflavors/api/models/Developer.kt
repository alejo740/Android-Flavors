package com.sample.demoflavors.api.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Developer (

    @SerializedName("type")
    @Expose
    val type: String? = null,

    @SerializedName("url")
    @Expose
    val url: String? = null,

    @SerializedName("name")
    @Expose
    val name: String? = null

)