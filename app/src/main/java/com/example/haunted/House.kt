package com.example.haunted

import android.util.Log

class House {

    // each room begins with an empty map of inventory
    var rooms: MutableMap<String, MutableMap<String, Item?>?> = mutableMapOf(
        "attic" to mutableMapOf<String, Item?>(),
        "bathroom" to mutableMapOf<String, Item?>(),
        "bedroom" to mutableMapOf<String, Item?>(),
        "cellar" to mutableMapOf<String, Item?>(),
        "dining" to mutableMapOf<String, Item?>(),
        "foyer" to mutableMapOf<String, Item?>(),
        "hall" to mutableMapOf<String, Item?>(),
        "kitchen" to mutableMapOf<String, Item?>(),
        "landing" to mutableMapOf<String, Item?>(),
        "nursery" to mutableMapOf<String, Item?>(),
        "outside" to mutableMapOf<String, Item?>(),
        "parlor" to mutableMapOf<String, Item?>(),
        "stairs" to mutableMapOf<String, Item?>(),
   )

    // items
    val items: Map<String, Item> = mapOf(
        "key" to Item("key", "An ornate rusty key"),
        "candle" to Item("candle", "A thick wax candle"),
        "matches" to Item("matches", "A pack of matches"),
    )

    init {
        // hide each item in a room
        items.forEach {
            // pick a random room
            val room = rooms.keys.random()
            // val room = "outside"
            // get items from room
            var hidden = rooms[room]
            if (hidden != null) {
                Log.d("DEBUG", "# items in room = ${hidden.size}")
                hidden.forEach { item ->
                    Log.d("DEBUG", "hidden = ${item.key}")
                }
            }
            // add item to inventory
            hidden?.set(it.key, it.value)
            Log.d("DEBUG", "hide the ${it.key.toString()} in the $room")
            // put items back into room
            rooms[room] = hidden
         }
    }
}