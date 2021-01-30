package com.example.myapplication

class WinLoseResult constructor(firstParticipantResult : GameOutcome,secondParticipantResult : GameOutcome) : Result{
    var firstParticipantResult: GameOutcome ?= null
    var secondParticipantResult: GameOutcome ?= null

    init {
        this.firstParticipantResult = firstParticipantResult
        this.secondParticipantResult = secondParticipantResult
    }

    override fun firstWins(): Boolean{
        if(firstParticipantResult == GameOutcome.WIN) return true else return false
    }

    override fun secondWins(): Boolean {
        if(secondParticipantResult == GameOutcome.WIN) return true else return false
    }

    override fun draws(): Boolean {
        if(firstParticipantResult == GameOutcome.DRAW) return true else return false
    }


}
