package com.example.getfive2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class RulesActivity : AppCompatActivity() {

    //lateinit var title2pView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rules)

        //title2pView=findViewById(R.id.ttl2TextView)

        var backRulesButton =findViewById<Button>(R.id.backRulesButton)

        backRulesButton.setOnClickListener{
            finish()
        }
    }
}