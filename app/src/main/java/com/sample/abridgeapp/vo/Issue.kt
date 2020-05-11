package com.sample.abridgeapp.vo

data class Issue(
    val title: String,
    val number: Int,
    val user: User,
    val createdAt: String
)