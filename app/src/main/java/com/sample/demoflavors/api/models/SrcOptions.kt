package com.sample.demoflavors.api.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SrcOptions (

    @SerializedName("source_skip")
    @Expose
    val sourceSkip: String? = null,

    @SerializedName("src_info")
    @Expose
    val srcInfo: String? = null,

    @SerializedName("skip_abstract")
    @Expose
    val skipAbstract: Int = 0,

    @SerializedName("is_fanon")
    @Expose
    val isFanon: Int = 0,

    @SerializedName("min_abstract_length")
    @Expose
    val minAbstractLength: String? = null,

    @SerializedName("skip_qr")
    @Expose
    val skipQr: String? = null,

    @SerializedName("is_mediawiki")
    @Expose
    val isMediawiki: Int = 0,

    @SerializedName("language")
    @Expose
    val language: String? = null,

    @SerializedName("is_wikipedia")
    @Expose
    val isWikipedia: Int = 0,

    @SerializedName("skip_icon")
    @Expose
    val skipIcon: Int = 0,

    @SerializedName("skip_end")
    @Expose
    val skipEnd: String? = null,

    @SerializedName("skip_abstract_paren")
    @Expose
    val skipAbstractParen: Int = 0,

    @SerializedName("skip_image_name")
    @Expose
    val skipImageName: Int = 0,

    @SerializedName("directory")
    @Expose
    val directory: String? = null

)