package com.sample.abridgeapp.network.vo

import com.google.gson.annotations.SerializedName
import com.sample.abridgeapp.vo.Issue

data class IssueSchema(
    @SerializedName("title") val title: String,
    @SerializedName("number") val number: Int,
    @SerializedName("user") val user: UserSchema,
    @SerializedName("created_at") val createdAt: String
) {
    fun toIssue() = Issue(title, number, user.toUser(), createdAt)
}