package com.example.cs4131_ppa.model

class User(
    var username: String,
    var password: String
) {
    companion object {
        var usernameList: ArrayList<String> = arrayListOf()
    }

    init {
        usernameList.add(username)
    }
}