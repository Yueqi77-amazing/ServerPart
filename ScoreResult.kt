package com.example.myapplication

class ScoreResult constructor(firstParticipantScore:Int, secondParticipantScore:Int):Result {
    var firstParticipantSorce: Int = 0
    var secondParticipantScore: Int = 0

    init {
        this.firstParticipantSorce = firstParticipantScore
        this.secondParticipantScore = secondParticipantScore
    }

    override fun firstWins(): Boolean{
        if(firstParticipantSorce > secondParticipantScore) return true else return false
    }

    override fun secondWins(): Boolean {
        if(firstParticipantSorce < secondParticipantScore) return true else return false
    }

    override fun draws(): Boolean {
        if(firstParticipantSorce == secondParticipantScore) return true else return false
    }

}