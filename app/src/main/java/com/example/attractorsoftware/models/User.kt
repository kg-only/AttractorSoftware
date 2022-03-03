package com.example.attractorsoftware.models

import com.google.gson.annotations.SerializedName


data class User(
    @SerializedName("first_name") val firstName: String,
    @SerializedName("photo") val photo: String,
    @SerializedName("second_name") val secondName: String,
    @SerializedName("education") val education: Int,
    @SerializedName("company") val company: List<Company>,
)