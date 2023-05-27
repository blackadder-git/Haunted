package com.example.haunted

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

var player = Player()
var house = House()
val paranormal = Paranormal()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val porch = findViewById<Button>(R.id.begin)
        porch.setOnClickListener {
            val intent = Intent(this, Outside::class.java)
            startActivity(intent)
        }
    }
}