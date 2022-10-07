package com.example.getfive2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class TwoPlayersActivity : AppCompatActivity() {

    lateinit var title2pView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two_players)

        title2pView=findViewById(R.id.ttl2TextView)
        val playerName1= intent.getStringExtra("user names")
        val playerName2= intent.getStringExtra("user names")
        Log.d("", "name?: $playerName1, $playerName2")

        var twopBackButton =findViewById<Button>(R.id.TwopBackButton)

        twopBackButton.setOnClickListener{
            finish()
        }
    }
}