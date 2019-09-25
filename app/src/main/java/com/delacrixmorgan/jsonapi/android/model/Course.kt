package com.delacrixmorgan.jsonapi.android.model

import kotlinx.serialization.Serializable

@Serializable
class Course(
    val id: String,
    val type: String,
    val title: String,
    val link: String
)