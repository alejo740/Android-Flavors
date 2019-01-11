package com.sample.demoflavors.api.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SearchModel (

    @SerializedName("DefinitionURL")
    @Expose
    val definitionURL: String? = null,

    @SerializedName("AbstractSource")
    @Expose
    val abstractSource: String? = null,

    @SerializedName("Answer")
    @Expose
    val answer: String? = null,

    @SerializedName("Heading")
    @Expose
    val heading: String? = null,

    @SerializedName("AbstractText")
    @Expose
    val abstractText: String? = null,

    @SerializedName("AbstractURL")
    @Expose
    val abstractURL: String? = null,

    @SerializedName("Type")
    @Expose
    val type: String? = null,

    @SerializedName("DefinitionSource")
    @Expose
    val definitionSource: String? = null,

    @SerializedName("Image")
    @Expose
    val image: String? = null,

    @SerializedName("Infobox")
    @Expose
    val infobox: String? = null,

    @SerializedName("RelatedTopics")
    @Expose
    val relatedTopics: List<RelatedTopic>? = null,

    @SerializedName("Abstract")
    @Expose
    val abstract: String? = null,

    @SerializedName("meta")
    @Expose
    val meta: Meta? = null,

    @SerializedName("ImageIsLogo")
    @Expose
    val imageIsLogo: Int = 0,

    @SerializedName("AnswerType")
    @Expose
    val answerType: String? = null,

    @SerializedName("Results")
    @Expose
    val results: List<Any>? = null,

    @SerializedName("ImageWidth")
    @Expose
    val imageWidth: Int = 0,

    @SerializedName("Redirect")
    @Expose
    val redirect: String? = null,

    @SerializedName("ImageHeight")
    @Expose
    val imageHeight: Int = 0,

    @SerializedName("Definition")
    @Expose
    val definition: String? = null,

    @SerializedName("Entity")
    @Expose
    val entity: String? = null

)
