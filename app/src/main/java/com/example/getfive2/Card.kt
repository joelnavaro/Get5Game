package com.example.getfive2

class Card(var value: Int, var suit: Int){
    var rank=""



    init {
        setTheRank()
    }

    fun setTheRank(){
        when(value){
            2-> rank=""
            3-> rank=""
            4-> rank=""
            5-> rank=""
            6-> rank=""
            7-> rank=""
            8-> rank=""
            9-> rank=""
            10-> rank=""
            11-> rank="J"
            12-> rank="Q"
            13-> rank="K"
            14-> rank="A"

        }
    }
}