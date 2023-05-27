package com.example.haunted

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Foyer : AppCompatActivity(), Room {

    override val room = "Foyer"
    // override val description = "Foyer"

    private var action : Action = Action()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_foyer)

        // determine whether the player is scared
        if (player.isScared()) {
            paranormal()
        }

        // load health and settings icon
        loadFragment()

        /*
        var hp = findViewById<TextView>(R.id.hp)
        hp.text = player.health.toString()

        // go to settings
        val settings = findViewById<ImageView>(R.id.gear)
        settings.setOnClickListener {
            val intent = Intent(this, Settings::class.java)
            intent.putExtra("roomKey", "Foyer")
            startActivity(intent)
        }
        */

        // search room for clues
        val search = findViewById<Button>(R.id.search)
        search.setOnClickListener {
            val result = action.search(room)
            var room = findViewById<TextView>(R.id.foyerText)
            room.text = result

            // Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
        }

        // go to hall
        val hall = findViewById<Button>(R.id.hall)
        hall.setOnClickListener {
            Log.d("DEBUG:", "Go to hall")
            val intent = Intent(this, Hall::class.java)
            startActivity(intent)
        }

        // go to stairs
        val stairs = findViewById<Button>(R.id.stairs)
        stairs.setOnClickListener {
            Log.d("DEBUG:", "Go to stairs")
            val intent = Intent(this, Stairs::class.java)
            startActivity(intent)
        }

        // go outside
        val porch = findViewById<Button>(R.id.outside)
        porch.setOnClickListener {
            Log.d("DEBUG:", "Go outside")
            val intent = Intent(this, Outside::class.java)
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