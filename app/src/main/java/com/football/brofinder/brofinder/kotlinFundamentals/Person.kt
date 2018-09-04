package com.football.brofinder.brofinder.kotlinFundamentals

import com.football.brofinder.brofinder.kotlinFundamentals.classes.Courses

abstract class Person{

    var firstName: String = ""
    var lastName: String = ""

    abstract fun getAddress(): String

    open fun getName(): String = "$firstName $lastName"

}

class Student(val id: Int) : Person() {
    override fun getAddress(): String {
        return "this is cool"
    }

    override fun getName(): String {
        return "override getName"
    }

    fun enrole(courseName : String){

        val course = Courses.allCourses.firstOrNull {it.Title == courseName}
    }
}