package com.example.getfive2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var titleView: TextView
    //lateinit var playersView: EditText
    lateinit var warningTextView: TextView
    lateinit var ev_name: EditText

    val userNames= mutableListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        titleView = findViewById(R.id.tTextView)
        ev_name=findViewById(R.id.NameEditView)
        warningTextView = findViewById(R.id.waTextView)
        var addButton= findViewById<Button>(R.id.addButton)


        addButton.setOnClickListener{
            takeUserName(ev_name.text.toString())

            Log.d("!!!","size:${userNames.size},${userNames[0]}")
        }


        var startButton = findViewById<Button>(R.id.gButton)
        startButton.setOnClickListener {
            handlePlayerButton()
            Log.d("!!!", "Knappen Trycktes")

        }
        var rulesButton = findViewById<Button>(R.id.rButton)
        rulesButton.setOnClickListener {
            showRulesBtn()
            Log.d("!!!", "Knappen Trycktes")

        }

    }

    fun takeUserName(nameTxt: String){
        if (nameTxt==""){
            userNames.add(nameTxt)
            ev_name.text.clear()
            ev_name.hint="Add a propper name"
        }else if (userNames.size >= 2){
            userNames.clear()
            ev_name.text.clear()
            ev_name.hint="Introduce only one Name"
        }else{
            userNames.clear()
            userNames.add(nameTxt)
            ev_name.text.clear()
            ev_name.hint = "Press Start Game"

        }
        //if(userNames.size<2){
        //}else{
            //warningTextView.text= "Max 2 players"
        //}
    }

    fun handlePlayerButton(){  //start game button

        if (userNames.size==1) {
            val intent = Intent(this, OnePlayerActivity::class.java)
            intent.putExtra("user_name", userNames[0])
            startActivity(intent)
        }else if(userNames.size==2){
            val intent = Intent(this, TwoPlayersActivity::class.java)
            intent.putExtra("user_names", userNames[0])
            intent.putExtra("user_names", userNames[1])
            startActivity(intent)
        }else{
            warningTextView.text= "Max 2 players"

        }

    }
    fun showRulesBtn(){
        val intent= Intent( this, RulesActivity:: class.java)
        startActivity(intent)
    }


}