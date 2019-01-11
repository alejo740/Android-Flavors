package com.sample.demoflavors.api.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Icon (

    @SerializedName("URL")
    @Expose
    val url: String? = null,

    @SerializedName("Width")
    @Expose
    val width: String? = null,

    @SerializedName("Height")
    @Expose
    val height: String? = null

)