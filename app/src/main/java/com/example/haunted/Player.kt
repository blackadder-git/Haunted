package com.example.haunted

import android.widget.Toast

class Player(health: Int = 100) {

    var health = health
        get() = field
        set(value) {
            field = value
        }

    // TODO: is there a way to modify this based on the number of rooms explored or the existing health ?
    fun isScared() : Boolean {
        var coinToss = ((0..100).shuffled().last() > 50)

        // if toss is over 50, player is scared
        if (coinToss) {
            val scare = (1..5).shuffled().last()
            health -= scare

            if (health <= 0) {
                // game over
            }
        }
        return coinToss
    }


}