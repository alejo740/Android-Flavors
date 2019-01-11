package com.sample.demoflavors.api.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Meta (

    @SerializedName("src_name")
    @Expose
    val srcName: String? = null,

    @SerializedName("producer")
    @Expose
    val producer: Any? = null,

    @SerializedName("dev_date")
    @Expose
    val devDate: Any? = null,

    @SerializedName("id")
    @Expose
    val id: String? = null,

    @SerializedName("status")
    @Expose
    val status: String? = null,

    @SerializedName("js_callback_name")
    @Expose
    val jsCallbackName: String? = null,

    @SerializedName("production_state")
    @Expose
    val productionState: String? = null,

    @SerializedName("perl_module")
    @Expose
    val perlModule: String? = null,

    @SerializedName("designer")
    @Expose
    val designer: Any? = null,

    @SerializedName("created_date")
    @Expose
    val createdDate: Any? = null,

    @SerializedName("example_query")
    @Expose
    val exampleQuery: String? = null,

    @SerializedName("is_stackexchange")
    @Expose
    val isStackexchange: Any? = null,

    @SerializedName("tab")
    @Expose
    val tab: String? = null,

    @SerializedName("topic")
    @Expose
    val topic: List<String>? = null,

    @SerializedName("dev_milestone")
    @Expose
    val devMilestone: String? = null,

    @SerializedName("description")
    @Expose
    val description: String? = null,

    @SerializedName("name")
    @Expose
    val name: String? = null,

    @SerializedName("unsafe")
    @Expose
    val unsafe: Int = 0,

    @SerializedName("signal_from")
    @Expose
    val signalFrom: String? = null,

    @SerializedName("developer")
    @Expose
    val developer: List<Developer>? = null,

    @SerializedName("src_id")
    @Expose
    val srcId: Int = 0,

    @SerializedName("src_options")
    @Expose
    val srcOptions: SrcOptions? = null,

    @SerializedName("attribution")
    @Expose
    val attribution: Any? = null,

    @SerializedName("maintainer")
    @Expose
    val maintainer: Maintainer? = null,

    @SerializedName("src_url")
    @Expose
    val srcUrl: Any? = null,

    @SerializedName("live_date")
    @Expose
    val liveDate: Any? = null,

    @SerializedName("blockgroup")
    @Expose
    val blockgroup: Any? = null,

    @SerializedName("src_domain")
    @Expose
    val srcDomain: String? = null,

    @SerializedName("repo")
    @Expose
    val repo: String? = null

)