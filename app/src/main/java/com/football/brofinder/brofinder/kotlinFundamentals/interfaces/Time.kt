package com.football.brofinder.brofinder.kotlinFundamentals.interfaces

interface Time {

    fun setTime(hours: Int, mins: Int = 0, secs: Int = 0)
}

class YetiTime : Time{
    override fun setTime(hours: Int, mins: Int, secs: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}