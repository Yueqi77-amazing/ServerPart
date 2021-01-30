package com.example.myapplication

import java.util.*

class TournamentDetail constructor(organisatorId: String, name: String, tournamentTypes: TournamentTypes, typeOfGame:String, location:String, registrationDeadline: Date, startTime:Date, endTime: Date, form:ParticipantForm) {
    val participantForm :ParticipantForm
    val adminId : String
    val tournamentName: String
    val tournamentTypes: TournamentTypes
    val typeOfGame: String
    val location: String
    val registrationDeadline: Date
    val startTime: Date
    val endTime: Date

    init{
        this.participantForm = form
        this.adminId = organisatorId
        this.tournamentName = name
        this.tournamentTypes = tournamentTypes
        this.typeOfGame = typeOfGame
        this.location = location
        this.registrationDeadline = registrationDeadline
        this.startTime = startTime
        this.endTime = endTime
    }
}