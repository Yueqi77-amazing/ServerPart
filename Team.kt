package com.example.myapplication

import java.util.*
import kotlin.collections.ArrayList

class Team constructor(name:String, password: String, adminId: String) : Participant() {
    var teamId: String
    var adminId: String
    var teamName: String
    var teamPassword: String
    var memberList: ArrayList<String>

    init{
        this.teamName = name
        this.teamPassword = password
        this.adminId = adminId
        this.teamId = randomId()
        this.memberList = ArrayList<String>()
        memberList.add(adminId)
    }

    private fun randomId():String{
        return UUID.randomUUID().toString()
    }

    override fun getParticipantName(): String {
        return teamName
    }

    override fun joinTournament(tournament: Tournament): Boolean {
        if(tournament.allowTeamToJoin()){
            tournamentList.add(tournament.tournamentId)
            tournament.addParticipant(teamId)
            return true
        } else return false
    }

    override fun quitTournament(tournament: Tournament): Boolean {
        tournamentList.remove(tournament.tournamentId)
        tournament.removeParticipant(teamId)
        return true
    }

    fun checkPasswort(password: String):Boolean{
        if(password == this.teamPassword) return true else return false
    }

    fun addMember(userId:String){
        memberList.add(userId)
    }

    fun removeMember(userId: String){
        memberList.remove(userId)
    }

    fun kickMember(user:User){
        removeMember(user.userId)
        user.teamList.remove(teamId)
    }

    fun checkAdmin(admin:User): Boolean{
        if(admin.userId == adminId) return true else return false
    }
}