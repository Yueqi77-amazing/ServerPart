package com.example.myapplication

import java.util.*

class Account constructor(email : String, password : String, username :String) {
    var id :String
    var email :String
    var password : String
        set
    var username: String
    var userId : String ?= null
        set
    init{
        this.email = email
        this.password = password
        this.username = username
        this.id = randomId()
    }

    private fun randomId():String{
        return UUID.randomUUID().toString()
    }
}