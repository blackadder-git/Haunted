package com.example.haunted

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class Landing : AppCompatActivity(), Room {

    override val room = "Landing"
    // override val description = "Landing"

    private var action : Action = Action()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)

        // determine whether the player is scared
        if (player.isScared()) {
            paranormal()
        }

        // load health and settings icon
        loadFragment()

        // search room for clues
        val search = findViewById<Button>(R.id.search)
        search.setOnClickListener {
            val result = action.search(room)
            var room = findViewById<TextView>(R.id.landingText)
            room.text = result

            // Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
        }

        // go to bedroom
        val bedroom = findViewById<Button>(R.id.bedroom)
        bedroom.setOnClickListener {
            Log.d("DEBUG:", "Go to bedroom")
            val intent = Intent(this, Bedroom::class.java)
            startActivity(intent)
        }

        // go to nursery
        val nursery = findViewById<Button>(R.id.nursery)
        nursery.setOnClickListener {
            Log.d("DEBUG:", "Go to nursery")
            val intent = Intent(this, Nursery::class.java)
            startActivity(intent)
        }

        // go to stairs
        val stairs = findViewById<Button>(R.id.stairs)
        stairs.setOnClickListener {
            Log.d("DEBUG:", "Go to stairs")
            val intent = Intent(this, Stairs::class.java)
            startActivity(intent)
        }

        // go to attic
        val attic = findViewById<Button>(R.id.attic)
        attic.setOnClickListener {
            Log.d("DEBUG:", "Go to attic")
            val intent = Intent(this, Attic::class.java)
            startActivity(intent)
        }
    }

    fun loadFragment() {
        // create a bundle
        val bundle = Bundle()
        // add information to pass to fragment
        bundle.putString("hp", player.health.toString())
        bundle.putString("room", room)
        // create object and attach arguments
        val testFragment = Test()
        testFragment.arguments = bundle

        // create fragment
        val fragment = supportFragmentManager.beginTransaction()
        fragment.add(R.id.fragment, testFragment)
        fragment.commit()
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