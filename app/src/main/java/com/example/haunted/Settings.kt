package com.example.haunted

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class Settings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        // get the class name of the calling activity
        val room = intent.getStringExtra("roomKey")
        findViewById<TextView>(R.id.settingsText).text = room

        // return to game
        val exit = findViewById<Button>(R.id.exit)
        exit.setOnClickListener {
            // return player to the last room they were in
            val roomClass = Class.forName("com.example.haunted.$room")
            val intent = Intent(this, roomClass)
            startActivity(intent)
        }
    }
}