package com.example.task_4

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Bank(
    @Json(name = "gps_x")
    val gps_x: Double,
    @Json(name = "gps_y")
    val gps_y: Double,
    @Json(name = "address_type")
    val address_type: String?,
    @Json(name = "address")
    val address: String?,
    @Json(name = "house")
    val house: String?
)