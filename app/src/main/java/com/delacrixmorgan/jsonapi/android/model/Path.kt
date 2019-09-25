package com.delacrixmorgan.jsonapi.android.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class Path(
    val id: String,
    val title: String,
    @SerialName("course_ids")
    val courseIds: Array<String>
)