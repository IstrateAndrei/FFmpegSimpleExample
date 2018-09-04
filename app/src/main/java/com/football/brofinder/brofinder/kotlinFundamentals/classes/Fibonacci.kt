package com.football.brofinder.brofinder.kotlinFundamentals.classes

import android.util.Log


interface Process{

    fun execute(value: Int)
}

class Fibonacci : Process{


    override fun execute(value: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        Log.e("Fibonacci", value.toString())
    }

    fun fibonacci(limit: Int, action : Process){

        var prev = 0
        var preprev = 0
        var current = 1

        for(i: Int in 1..limit){
            action.execute(current)

            var temp = current
            preprev = prev
            prev = temp
            current = preprev + prev
        }
    }
}