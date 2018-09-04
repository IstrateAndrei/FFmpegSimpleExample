package com.football.brofinder.brofinder.data.models

import android.util.Log
import java.util.jar.Attributes

class Person(var Name: String) {


    fun displayName(){
        Log.e("Kotlin","Display: $Name")
    }

    fun displayWithLambda(func: (s:String) -> Unit){
        func(Name)
    }
}