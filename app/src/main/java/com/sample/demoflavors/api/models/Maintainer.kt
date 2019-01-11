package com.sample.demoflavors.api.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Maintainer (

    @SerializedName("github")
    @Expose
    val github: String? = null

)