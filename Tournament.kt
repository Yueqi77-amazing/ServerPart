package com.example.myapplication

import java.util.*
import kotlin.collections.ArrayList

abstract class Tournament constructor(participantSize:Int,tournamentDetail:TournamentDetail) : Searchable{
    var tournamentId : String
    var tournamentDetail: TournamentDetail
    var gameList: ArrayList<String>
    var participantList: Array<String?>

    init{
        this.tournamentId = randomId()
        this.tournamentDetail = tournamentDetail
        this.gameList = ArrayList<String>()
        this.participantList = arrayOfNulls<String>(participantSize)
    }

    private fun randomId():String{
        return UUID.randomUUID().toString()
    }

    private fun getFirstNullIndex() = (0..participantList.size).first { participantList[it] == null }

    override fun getTitle(): String {
        return tournamentDetail.tournamentName
    }

    override fun getInformation(): String {
        return """
            |Tournament: ${tournamentDetail.tournamentName}
            |Participantform: ${tournamentDetail.participantForm}
            |Location: ${tournamentDetail.location}
            |Game: ${tournamentDetail.typeOfGame}
            |Time: from ${tournamentDetail.startTime} to ${tournamentDetail.endTime}
            |Register: before ${tournamentDetail.registrationDeadline}
        """.trimMargin()
    }

    abstract fun createGames()

    fun addGame(gameId:String){
        gameList.add(gameId)
    }

    fun removeGame(gameId:String){
        gameList.remove(gameId)
    }

    fun addParticipant(participantId:String){
        participantList[getFirstNullIndex()] = participantId
    }

    fun removeParticipant(participantId: String){
        var index:Int = (0..participantList.size).first { participantList[it] == participantId }
        participantList[index] = null
    }

    fun allowUserToJoin():Boolean{
        if(tournamentDetail.participantForm == ParticipantForm.SINGLE) {
            if(checkSize())
                return true else return false
        }
        else return false
    }

    fun allowTeamToJoin():Boolean{
        if(tournamentDetail.participantForm == ParticipantForm.TEAM) {
            if(checkSize())
                return true else return false
        }
        else return false
    }

    fun checkSize():Boolean {
        for (item in participantList){
            if(item == null) return true else return false
        }
        throw NoSuchElementException("no num")
    }

    fun readyToBeHeld():Boolean{
        if (!checkSize()) return true else return false
    }

    fun isOpen():Boolean{
        if(tournamentDetail.tournamentTypes == TournamentTypes.OPEN) return true else return false
    }

    fun isAdmin(userId:String):Boolean{
        if(tournamentDetail.adminId == userId) return true else return false
    }
}