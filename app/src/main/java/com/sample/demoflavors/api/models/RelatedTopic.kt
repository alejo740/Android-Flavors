package com.sample.demoflavors.api.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RelatedTopic (

    @SerializedName("Icon")
    @Expose
    val icon: Icon? = null,

    @SerializedName("FirstURL")
    @Expose
    val firstURL: String? = null,

    @SerializedName("Text")
    @Expose
    val text: String? = null,

    @SerializedName("Result")
    @Expose
    var result: String? = null
)