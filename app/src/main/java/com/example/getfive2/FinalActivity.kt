package com.example.getfive2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class FinalActivity : AppCompatActivity() {
    //c1_win_Iv
    lateinit var ttlView: TextView
    lateinit var winBoxView:TextView

    lateinit var c1_winiView: ImageView
    lateinit var c2_winiView: ImageView
    lateinit var c3_winiView: ImageView
    lateinit var c4_winiView: ImageView
    lateinit var c5_winiView: ImageView
                                        //value c1_winTv
    lateinit var c1_winTxtv: TextView
    lateinit var c2_winTxtv: TextView
    lateinit var c3_winTxtv: TextView
    lateinit var c4_winTxtv: TextView
    lateinit var c5_winTxtv: TextView

                                       //rank c1_winRv
    lateinit var c1_RkVw: TextView
    lateinit var c2_RkVw: TextView
    lateinit var c3_RkVw: TextView
    lateinit var c4_RkVw: TextView
    lateinit var c5_RkVw: TextView
    var winnerHand=CardGame()
    var recoverList= mutableListOf<Card>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        ttlView= findViewById(R.id.winner_txtView)
        winBoxView=findViewById(R.id.winNameTv)

        c1_winiView= findViewById(R.id.c1_win_Iv)
        c2_winiView=  findViewById(R.id.c2_win_Iv)
        c3_winiView= findViewById(R.id.c3_win_Iv)
        c4_winiView= findViewById(R.id.c4_win_Iv)
        c5_winiView= findViewById(R.id.c5_win_Iv)

        c1_winTxtv= findViewById(R.id.c1_winTv)
        c2_winTxtv= findViewById(R.id.c2_winTv)
        c3_winTxtv= findViewById(R.id.c3_winTv)
        c4_winTxtv= findViewById(R.id.c4_winTv)
        c5_winTxtv= findViewById(R.id.c5_winTv)

        c1_RkVw= findViewById(R.id.c1_winRv)
        c2_RkVw= findViewById(R.id.c2_winRv)
        c3_RkVw= findViewById(R.id.c3_winRv)
        c4_RkVw= findViewById(R.id.c4_winRv)
        c5_RkVw= findViewById(R.id.c5_winRv)

        var finishBttn= findViewById<Button>(R.id.finishBttn)


        val nameOfPlayer= intent.getStringExtra("nameOfPlayer")
        Log.d("!!!","$nameOfPlayer")
        winBoxView.text= nameOfPlayer.toString()

        val card1Value= intent.getIntExtra("h1_v",-1)
        val card2Value= intent.getIntExtra("h2_v",-1)
        val card3Value= intent.getIntExtra("h3_v",-1)
        val card4Value= intent.getIntExtra("h4_v",-1)
        val card5Value= intent.getIntExtra("h5_v",-1)

        val card1suit=intent.getIntExtra("h1_s",-1)
        val card2suit=intent.getIntExtra("h2_s",-1)
        val card3suit=intent.getIntExtra("h3_s",-1)
        val card4suit=intent.getIntExtra("h4_s",-1)
        val card5suit=intent.getIntExtra("h5_s",-1)

        val card1rank=intent.getStringExtra("h1_r")
        val card2rank=intent.getStringExtra("h2_r")
        val card3rank=intent.getStringExtra("h3_r")
        val card4rank=intent.getStringExtra("h4_r")
        val card5rank=intent.getStringExtra("h5_r")

        recoverList.add(Card(card1Value,card1suit))
        recoverList.add(Card(card2Value,card2suit))
        recoverList.add(Card(card3Value,card3suit))
        recoverList.add(Card(card4Value,card4suit))
        recoverList.add(Card(card5Value,card5suit))



        c1_winiView.setImageResource(recoverList[0].suit)
        c2_winiView.setImageResource(recoverList[1].suit)
        c3_winiView.setImageResource(recoverList[2].suit)
        c4_winiView.setImageResource(recoverList[3].suit)
        c5_winiView.setImageResource(recoverList[4].suit)

        c1_winTxtv.text= recoverList[0].value.toString()
        c2_winTxtv.text= recoverList[0].value.toString()
        c3_winTxtv.text= recoverList[0].value.toString()
        c4_winTxtv.text= recoverList[0].value.toString()
        c5_winTxtv.text= recoverList[0].value.toString()

        c1_RkVw.text= card1rank.toString()
        c2_RkVw.text= card2rank.toString()
        c3_RkVw.text= card3rank.toString()
        c4_RkVw.text= card4rank.toString()
        c5_RkVw.text= card5rank.toString()



        finishBttn.setOnClickListener{
             finish()

        }


    }


}