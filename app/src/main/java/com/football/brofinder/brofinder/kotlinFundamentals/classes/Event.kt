package com.football.brofinder.brofinder.kotlinFundamentals.classes

sealed class Event(param1: String, param2: Int) {

    class SendEvent(id: Int, to: String) : Event(to,id)
    class ReceiveEvent(id: Int, from: String) : Event(from,id)

    var param1 : String? = null
    var param2 : Int? = 0

    init{
        this.param1 = param1
        this.param2 = param2
    }

}

fun handleEvent(event : Event){
    when(event){
        is Event.SendEvent -> println("Sending")
        is Event.ReceiveEvent -> println("Receiving")
    }
}