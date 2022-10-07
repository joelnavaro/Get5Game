package com.example.getfive2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class OnePlayerActivity : AppCompatActivity() {
    //suit
    lateinit var title1pView: TextView
    lateinit var iv_Card1: ImageView
    lateinit var iv_Card2: ImageView
    lateinit var iv_Card3: ImageView
    lateinit var iv_Card4: ImageView
    lateinit var iv_Card5: ImageView
    lateinit var iv_newCard: ImageView

    //value
    lateinit var card1_tv: TextView
    lateinit var card2_tv: TextView
    lateinit var card3_tv: TextView
    lateinit var card4_tv: TextView
    lateinit var card5_tv: TextView
    lateinit var newCardtxView: TextView
    lateinit var newCardRankView: TextView

    //rank
    lateinit var c1_RankView: TextView
    lateinit var c2_RankView: TextView
    lateinit var c3_RankView: TextView
    lateinit var c4_RankView: TextView
    lateinit var c5_RankView: TextView

    var cardGame = CardGame()
    var newCard = mutableListOf<Card>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_player)

        title1pView = findViewById(R.id.ttlTextView)
        //suit
        iv_Card1 = findViewById(R.id.c1p1_imgView)
        iv_Card2 = findViewById(R.id.c2p1_imgView)
        iv_Card3 = findViewById(R.id.c3p1_imgView)
        iv_Card4 = findViewById(R.id.c4p1_imgView)
        iv_Card5 = findViewById(R.id.c5p1_imgView)
        iv_newCard = findViewById(R.id.c6p1_imgView)
        //avslöjar ett kort
        val takeNewCardButton = findViewById<Button>(R.id.setTablebutton)

        var backPlayerButton = findViewById<Button>(R.id.backPlayerButton)
        //value
        card1_tv = findViewById(R.id.tv_c1_View)
        card2_tv = findViewById(R.id.tv_c2_View)
        card3_tv = findViewById(R.id.tv_c3_View)
        card4_tv = findViewById(R.id.tv_c4_View)
        card5_tv = findViewById(R.id.tv_c5_View)
        newCardtxView = findViewById(R.id.newCardView)
        newCardRankView = findViewById(R.id.ncRankView)
        //rank
        c1_RankView = findViewById(R.id.c1_rankView)
        c2_RankView = findViewById(R.id.c2_rankView)
        c3_RankView = findViewById(R.id.c3_rankView)
        c4_RankView = findViewById(R.id.c4_rankView)
        c5_RankView = findViewById(R.id.c5_rankView)

        var playerName = intent.getStringExtra("user_name")
        Log.d("", "name?: $playerName")

        Log.d("!!!", "size of the deck is: ${cardGame.deckOfCards.size} ")


        var player1 = CardGame.Player(playerName, cardGame.setHand())

        iv_Card1.setOnClickListener {
            if (newCard.isEmpty()) {
                revealCards(player1.playerHand)
            } else {
                swapCards1(0, newCard.last(), player1.playerHand)
                check(player1.playerHand,playerName!!)
            }
        }
        iv_Card2.setOnClickListener {
            if (newCard.isEmpty()) {
                revealCards(player1.playerHand)
            } else {
                swapCards2(1, newCard.last(), player1.playerHand)
                check(player1.playerHand,playerName!!)
            }
        }
        iv_Card3.setOnClickListener {
            if (newCard.isEmpty()) {
                revealCards(player1.playerHand)
            } else {
                swapCards3(2, newCard.last(), player1.playerHand)
                check(player1.playerHand,playerName!!)
            }
        }
        iv_Card4.setOnClickListener {
            if (newCard.isEmpty()) {
                revealCards(player1.playerHand)
            } else {
                swapCards4(3, newCard.last(), player1.playerHand)
                check(player1.playerHand,playerName!!)
            }
        }
        iv_Card5.setOnClickListener {
            if (newCard.isEmpty()) {
                revealCards(player1.playerHand)
            } else {
                swapCards5(4, newCard.last(), player1.playerHand)
                check(player1.playerHand,playerName!!)
            }
        }


        takeNewCardButton.setOnClickListener {
            if (cardGame.usedCards.size == cardGame.deckOfCards.size) {
                cardGame.usedCards.clear()
                cardGame.usedCards.addAll(player1.playerHand)
                takeNewCard()
            } else {
                revealCards(player1.playerHand)
                takeNewCard()
            }
            Log.d(
                "!!!", "card taken, deck size:${cardGame.deckOfCards.size}," +
                        " hand size${player1.playerHand.size}, " +
                        "used card size: ${cardGame.usedCards.size}"
            )
        }

        backPlayerButton.setOnClickListener {
            finish()
        }
    }

    //visa ett nytt kort från deck
    fun takeNewCard() {
        var currentCard: Card?
        do {
            val rnd = (0 until cardGame.deckOfCards.size).random()
            currentCard = cardGame.deckOfCards[rnd]
        } while (cardGame.usedCards.contains(currentCard))
        newCard.add(currentCard!!)
        cardGame.usedCards.add(currentCard)

        iv_newCard.setImageResource(newCard.last().suit)

        newCardtxView.text = newCard.last().value.toString()
        newCardRankView.text = newCard.last().rank

    }

    fun swapCards1(index: Int, card: Card, hand: MutableList<Card>): MutableList<Card> {
        if(hand.contains(card)){
            Toast.makeText(this,"Take a new card!",Toast.LENGTH_LONG).show()
        }else{
            hand.removeAt(index)
            hand.add(index, card)
        }

        iv_Card1.setImageResource(hand[0].suit)
        card1_tv.text = hand[0].value.toString()
        c1_RankView.text = hand[0].rank

        iv_newCard.setImageResource(R.drawable.question)
        newCardtxView.text = ""
        newCardRankView.text = ""

        return hand
    }

    fun swapCards2(index: Int, card: Card, hand: MutableList<Card>): MutableList<Card> {
        if(hand.contains(card)){
            Toast.makeText(this,"Take a new card!",Toast.LENGTH_LONG).show()
        }else{
            hand.removeAt(index)
            hand.add(index, card)
        }

        iv_Card2.setImageResource(hand[1].suit)
        card2_tv.text = hand[1].value.toString()
        c2_RankView.text = hand[1].rank

        iv_newCard.setImageResource(R.drawable.question)
        newCardtxView.text = ""
        newCardRankView.text = ""

        return hand
    }

    fun swapCards3(index: Int, card: Card, hand: MutableList<Card>): MutableList<Card> {
        if(hand.contains(card)){
            Toast.makeText(this,"Take a new card!",Toast.LENGTH_LONG).show()
        }else{
            hand.removeAt(index)
            hand.add(index, card)
        }

        iv_Card3.setImageResource(hand[2].suit)
        card3_tv.text = hand[2].value.toString()
        c3_RankView.text = hand[2].rank

        iv_newCard.setImageResource(R.drawable.question)
        newCardtxView.text = ""
        newCardRankView.text = ""

        return hand
    }

    fun swapCards4(index: Int, card: Card, hand: MutableList<Card>): MutableList<Card> {
        if(hand.contains(card)){
            Toast.makeText(this,"Take a new card!",Toast.LENGTH_LONG).show()
        }else{
            hand.removeAt(index)
            hand.add(index, card)
        }

        iv_Card4.setImageResource(hand[3].suit)
        card4_tv.text = hand[3].value.toString()
        c4_RankView.text = hand[3].rank

        iv_newCard.setImageResource(R.drawable.question)
        newCardtxView.text = ""
        newCardRankView.text = ""

        return hand
    }

    fun swapCards5(index: Int, card: Card, hand: MutableList<Card>): MutableList<Card> {
        if(hand.contains(card)){
            Toast.makeText(this,"Take a new card!",Toast.LENGTH_LONG).show()
        }else{
            hand.removeAt(index)
            hand.add(index, card)
        }

        iv_Card5.setImageResource(hand[4].suit)
        card5_tv.text = hand[4].value.toString()
        c5_RankView.text = hand[4].rank

        iv_newCard.setImageResource(R.drawable.question)
        newCardtxView.text = ""
        newCardRankView.text = ""

        return hand
    }                                           //reveal cards in the hand

    fun revealCards(hand: MutableList<Card>) {

        iv_Card1.setImageResource(hand[0].suit)
        iv_Card2.setImageResource(hand[1].suit)
        iv_Card3.setImageResource(hand[2].suit)
        iv_Card4.setImageResource(hand[3].suit)
        iv_Card5.setImageResource(hand[4].suit)

        card1_tv.text = hand[0].value.toString()
        card2_tv.text = hand[1].value.toString()
        card3_tv.text = hand[2].value.toString()
        card4_tv.text = hand[3].value.toString()
        card5_tv.text = hand[4].value.toString()

        c1_RankView.text = hand[0].rank
        c2_RankView.text = hand[1].rank
        c3_RankView.text = hand[2].rank
        c4_RankView.text = hand[3].rank
        c5_RankView.text = hand[4].rank

    }

    //separates cards
    fun check(hand: MutableList<Card>,name:String): MutableList<Card> {

        var max = hand.size - 1            //sista kort
        for (card in 0 until max) {
            var cardLeft = max - card          //kort på vänster
            for (card in 0 until cardLeft) {
                if (hand[card].value > hand[card + 1].value) {
                    val temp = hand[card]
                    hand[card] = hand[card + 1]
                    hand[card + 1] = temp
                }
            }
        }                                               //shows new order
        //-------
        iv_Card1.setImageResource(hand[0].suit)
        iv_Card2.setImageResource(hand[1].suit)
        iv_Card3.setImageResource(hand[2].suit)
        iv_Card4.setImageResource(hand[3].suit)
        iv_Card5.setImageResource(hand[4].suit)

        card1_tv.text = hand[0].value.toString()
        card2_tv.text = hand[1].value.toString()
        card3_tv.text = hand[2].value.toString()
        card4_tv.text = hand[3].value.toString()
        card5_tv.text = hand[4].value.toString()

        c1_RankView.text = hand[0].rank
        c2_RankView.text = hand[1].rank
        c3_RankView.text = hand[2].rank
        c4_RankView.text = hand[3].rank
        c5_RankView.text = hand[4].rank
        // 222,33  eller 22,333
 
        if (hand[0].value == hand[1].value
            && hand[0].value == hand[2].value
            && hand[3].value == hand[4].value
        ) {
            Log.d("!!!", "Intent")

            val intent = Intent(this, FinalActivity::class.java)
            intent.putExtra("nameOfPlayer", name)
            intent.putExtra("h1_v",hand[0].value)
            intent.putExtra("h2_v",hand[1].value)
            intent.putExtra("h3_v",hand[2].value)
            intent.putExtra("h4_v",hand[3].value)
            intent.putExtra("h5_v",hand[4].value)
            intent.putExtra("h1_s",hand[0].suit)
            intent.putExtra("h2_s",hand[1].suit)
            intent.putExtra("h3_s",hand[2].suit)
            intent.putExtra("h4_s",hand[3].suit)
            intent.putExtra("h5_s",hand[4].suit)
            intent.putExtra("h1_r",hand[0].rank)
            intent.putExtra("h2_r",hand[1].rank)
            intent.putExtra("h3_r",hand[2].rank)
            intent.putExtra("h4_r",hand[3].rank)
            intent.putExtra("h5_r",hand[4].rank)
            startActivity(intent)

            return hand


        } else if (hand[0].value == hand[1].value
            && hand[2].value == hand[3].value
            && hand[2].value == hand[4].value
        ) {

            Log.d("!!!", "Intent")

            val intent = Intent(this, FinalActivity::class.java)
            intent.putExtra("nameOfPlayer",name )
            intent.putExtra("h1_v",hand[0].value)
            intent.putExtra("h2_v",hand[1].value)
            intent.putExtra("h3_v",hand[2].value)
            intent.putExtra("h4_v",hand[3].value)
            intent.putExtra("h5_v",hand[4].value)
            intent.putExtra("h1_s",hand[0].suit)
            intent.putExtra("h2_s",hand[1].suit)
            intent.putExtra("h3_s",hand[2].suit)
            intent.putExtra("h4_s",hand[3].suit)
            intent.putExtra("h5_s",hand[4].suit)
            intent.putExtra("h1_r",hand[0].rank)
            intent.putExtra("h1_r",hand[1].rank)
            intent.putExtra("h1_r",hand[2].rank)
            intent.putExtra("h1_r",hand[3].rank)
            intent.putExtra("h1_r",hand[4].rank)
            startActivity(intent)

            return hand

        } else {
            Log.d("!!!", "Intent not yet")
            return hand
        }
    }

    override fun onRestart() {
        super.onRestart()
    }


}