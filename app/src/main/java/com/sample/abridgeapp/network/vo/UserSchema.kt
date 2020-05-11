package com.sample.abridgeapp.network.vo

import com.google.gson.annotations.SerializedName
import com.sample.abridgeapp.vo.User

class UserSchema(@SerializedName("login") val login: String) {
    fun toUser() = User(login)
}
