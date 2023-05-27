package com.example.haunted

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class Hall : AppCompatActivity(), Room {

    override val room = "Hall"
    // override val description = "Hall"

    private var action : Action = Action()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hall)

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
            var room = findViewById<TextView>(R.id.hallText)
            room.text = result

            // Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
        }

        // go to parlor
        val parlor = findViewById<Button>(R.id.parlor)
        parlor.setOnClickListener {
            Log.d("DEBUG:", "Go to parlor")
            val intent = Intent(this, Parlor::class.java)
            startActivity(intent)
        }

        // go to dining
        val dining = findViewById<Button>(R.id.dining)
        dining.setOnClickListener {
            Log.d("DEBUG:", "Go to dining")
            val intent = Intent(this, Dining::class.java)
            startActivity(intent)
        }

        // go to foyer
        val foyer = findViewById<Button>(R.id.foyer)
        foyer.setOnClickListener {
            Log.d("DEBUG:", "Go to foyer")
            val intent = Intent(this, Foyer::class.java)
            startActivity(intent)
        }

        // go to cellar
        val cellar = findViewById<Button>(R.id.cellar)
        cellar.setOnClickListener {
            Log.d("DEBUG:", "Go to cellar")
            val intent = Intent(this, Cellar::class.java)
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