package com.example.attractorsoftware.models

import com.google.gson.annotations.SerializedName


data class Company(
    @SerializedName("name") val name: String,
    @SerializedName("position") val position: String,
)