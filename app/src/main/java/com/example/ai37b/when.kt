package com.example.ai37b

fun main() {
    print("Please enter a month number of the year: - ")
    var monthNumber : Int = readln()!!.toInt()
    var month : String
    when(monthNumber)
    {
        1 -> month = "January"
        2 -> month = "February"
        3 -> month = "March"
        4 -> month = "April"
        5 -> month = "May"
        6 -> month = "June"
        7 -> month = "July"
        8 -> month = "August"
        9 -> month = "September"
        10 -> month = "October"
        11 -> month = "November"
        12 -> month = "December"
        else -> month = "Invalid month choice"
    }
    print(month)
}