package com.example.myapplication

import java.util.*

class Invitation constructor(senderName: String, recipientUserName: String, tournamentID: String) {
    var invitationId: String
    var senderName:String
    var recipientUsername:String
    var tournamentId:String

    init{
        this.invitationId = randomId()
        this.senderName = senderName
        this.recipientUsername = recipientUserName
        this.tournamentId = tournamentID
    }
    private fun randomId():String{
        return UUID.randomUUID().toString()
    }
}