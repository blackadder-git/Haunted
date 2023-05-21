package com.example.haunted

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class Landing : AppCompatActivity(), Room {

    override val description = "Landing"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)

        if (player.isScared()) {
            paranormal()
        }

        var hp = findViewById<TextView>(R.id.hp)
        hp.text = player.health.toString()

        // var room = findViewById<TextView>(R.id.landingText)
        // room.text = description

        // go to settings
        val settings = findViewById<Button>(R.id.settings)
        settings.setOnClickListener {
            val intent = Intent(this, Settings::class.java)
            intent.putExtra("roomKey", "Landing")
            startActivity(intent)
        }

        // search room for clues
        val search = findViewById<Button>(R.id.search)
        search.setOnClickListener {
            search()
        }

        // go to bedroom
        val bedroom = findViewById<Button>(R.id.bedroom)
        bedroom.setOnClickListener {
            val intent = Intent(this, Bedroom::class.java)
            startActivity(intent)
        }

        // go to nursery
        val nursery = findViewById<Button>(R.id.nursery)
        nursery.setOnClickListener {
            val intent = Intent(this, Nursery::class.java)
            startActivity(intent)
        }

        // go to stairs
        val stairs = findViewById<Button>(R.id.stairs)
        stairs.setOnClickListener {
            val intent = Intent(this, Stairs::class.java)
            startActivity(intent)
        }

        // go to attic
        val attic = findViewById<Button>(R.id.attic)
        attic.setOnClickListener {
            val intent = Intent(this, Attic::class.java)
            startActivity(intent)
        }
    }

    // what happens when you search this room?
    override fun search() {
        Toast.makeText(this, "Search Landing", Toast.LENGTH_SHORT).show()
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