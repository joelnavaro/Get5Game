package com.example.getfive2

class CardGame() {

    var deckOfCards = mutableListOf<Card>()
    var usedCards = mutableListOf<Card>()
    class Player(var name: String? , var playerHand: MutableList<Card>) {

    }

    init {
        createCards()
    }
    fun createCards(): List<Card> {
        for (card in 1..13) {
            var c_spades = Card(card + 1, R.drawable.img_spades)
            deckOfCards.add(c_spades)
            var c_hearts = Card(card + 1, R.drawable.img_heart)
            deckOfCards.add(c_hearts)
            var c_clubs = Card(card + 1, R.drawable.img_clubs)
            deckOfCards.add(c_clubs)
            var c_diamonds = Card(card + 1, R.drawable.img_diamonds)
            deckOfCards.add(c_diamonds)
        }
        return deckOfCards.shuffled()
    }
    fun setHand(count: Int=5): MutableList<Card> {
        var playerCards = mutableListOf<Card>()

        for (round in 1..count) {
            var rnd = (0 until deckOfCards.size).random()
            playerCards.add(deckOfCards[rnd])
            usedCards.add(deckOfCards[rnd])
        }

        return playerCards
    }



}
