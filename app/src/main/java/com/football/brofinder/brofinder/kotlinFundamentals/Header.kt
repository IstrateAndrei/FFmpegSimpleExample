package com.football.brofinder.brofinder.kotlinFundamentals



class Header(var Name: String){


}

infix operator fun Header.plus(other: Header): Header{

    return Header(this.Name + other.Name)
}
