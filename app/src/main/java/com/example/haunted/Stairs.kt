package com.example.haunted

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class Stairs : AppCompatActivity(), Room {

    override val description = "Stairs"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stairs)

        if (player.isScared()) {
            paranormal()
        }

        var hp = findViewById<TextView>(R.id.hp)
        hp.text = player.health.toString()

        // var room = findViewById<TextView>(R.id.stairsText)
        // room.text = description

        // go to settings
        val settings = findViewById<Button>(R.id.settings)
        settings.setOnClickListener {
            val intent = Intent(this, Settings::class.java)
            intent.putExtra("roomKey", "Stairs")
            startActivity(intent)
        }

        // search room for clues
        val search = findViewById<Button>(R.id.search)
        search.setOnClickListener {
            search()
        }

        // go to landing
        val landing = findViewById<Button>(R.id.landing)
        landing.setOnClickListener {
            val intent = Intent(this, Landing::class.java)
            startActivity(intent)
        }

        // go to foyer
        val foyer = findViewById<Button>(R.id.foyer)
        foyer.setOnClickListener {
            val intent = Intent(this, Foyer::class.java)
            startActivity(intent)
        }
    }

    // what happens when you search this room?
    override fun search() {
        Toast.makeText(this, "Search Stairs", Toast.LENGTH_SHORT).show()
    }

    override fun paranormal() {
        var scare = ""
        val ghost = (1..99).shuffled().last()

        // replace assignment inside of if/else
        scare = if (ghost < 33) {
            Paranormal().sounds.random()
        }
        else if (ghost < 66) {
            Paranormal().sights.random()
        }
        else {
            Paranormal().smells[Paranormal().smells.keys.random()].toString()
        }

        Toast.makeText(this, "$scare", Toast.LENGTH_SHORT).show()
    }
}