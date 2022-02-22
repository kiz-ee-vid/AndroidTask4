package com.example.task_4

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Bank(
    @Json(name = "gps_x")
    val gps_x: Double,
    @Json(name = "gps_y")
    val gps_y: Double
)