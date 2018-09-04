package com.football.brofinder.brofinder.presentation.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.football.brofinder.brofinder.R
import com.football.brofinder.brofinder.data.models.Person
import com.football.brofinder.brofinder.data.models.Question
import com.football.brofinder.brofinder.kotlinFundamentals.Header
import com.football.brofinder.brofinder.kotlinFundamentals.Student
import com.football.brofinder.brofinder.kotlinFundamentals.plus
import java.math.BigInteger
import java.util.*

@Suppress("NAME_SHADOWING")
class KotlinFundamentals : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val human = Person("Steeeve")
        human.displayName()


//        ---------------------------------------------------
//        Module III - Getting Started with Kotlin
//        ---------------------------------------------------

        //this one is interesting
        human.displayWithLambda(::displayMain)

        val q: Question? = Question()
        q?.Answer = "To live it!(33)"

//        Log.i("Testing", "The answer for the question '${q?.Question}' is ${q?.Answer} ")

        // in kotlin you can compare 2 strings using the equality operators
        if (q?.Answer == q?.CorrectAnswer) {
            // the answer is correct
        } else {
            // try again
        }

        //in kotlin you can set the value of a variable based on the if statement - 'if' is also an expression
        var message = if (q?.Answer == q?.CorrectAnswer) {
            "You were correct"
        } else {
            "Try again"
        }

        // when statement = switch in java

        when (q?.Answer) {
            q?.CorrectAnswer -> Log.e("Display", "Correct answer")
            else -> Log.e("Display", "try again")
        }

        val number: Int? = try {
            Integer.valueOf(q?.Answer)
        } catch (e: NumberFormatException) {
            null
        }

//        Log.e("Number:", "$number")

//        //simple for syntax -> downTo ; step; until;
//        for(i in 12 downTo 1 step 2 ){
//            Log.e("Loop", "$i")
//        }
//
//        //Tree map for
//        val ages = TreeMap<String, Int>()
//        ages["Ionut"] = 20
//        ages["Misu"] = 22
//        ages["Constantin"] = 25
//        ages["Marcel"] = 33
//
//        for((name,age) in ages){
//            Log.e(name,"is $age")
//        }

//        val index = 1..10
//        for((element,index) in index.withIndex()){
//            Log.e("$element","is at $index")
//        }

//        ------------------------------------------
//        Module IV --- Functions in Kotlin
//        ------------------------------------------

//        Log.e("Function", "${max(7, 8)}")
//        //normal function
//        defaultParam("default message")
//
//        //change the suffix param
//        defaultParam(  "just a random message", "ended")
//
//        //named parameters function
//        //function with named parameters - if you name them you must name all of them -- useful when you want to change the order of the parameters
//        defaultParam(message = "just a random message", suffix = "ended")
//
//        val text:String = "Hai sa     vedem ce           o sa iasa"
//        Log.e("Extension", text.replaceExtraSpace())
//    }

//  ------- INFIX FUNCTION EXAMPLE ----------
//        used to make an operator out of an function --- cool stuff - beware of overusing it -> can lead to confusing code
//        used for operator overloading
        val h1 = Header("H1")
        val h2 = Header("H2")

        val h3 = h1 plus h2

        val h4 = h1 + h3

        Log.e("Header", h4.Name)
        Log.e("Header", h3.Name)


//        TAIL RECURSIVE FUNCTIONS
        Log.e("TAIL_REC", "${fib(10000, BigInteger("1"), BigInteger("0"))}")

        var Katalin = Student(10)


    }

//    //simple one line function - very nice
//    fun max(a: Int, b: Int): Int = if (a > b) a else b
//
//    //functions with default parameters
//    fun defaultParam(message: String, suffix: String = "default") {
//
//        Log.e("DefaultParam", "$message and suffix is $suffix")
//    }

    fun displayMain(name: String) {
        Log.e("Kotlin", "Display: $name")
    }

    tailrec fun fib(n: Int, a: BigInteger, b: BigInteger): BigInteger {
        return if (n == 0) b else fib(n - 1, a + b, a)
    }
}


//extension method

fun String.replaceExtraSpace(): String {
    val regex = Regex("\\s+")
    return regex.replace(this, " ")
}