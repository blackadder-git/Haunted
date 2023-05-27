package com.example.haunted

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.util.Log

class Action {

    private var mediaPlayer : MediaPlayer? = null

    /*****************************************
    *  Search room
    ******************************************/
    fun search(room: String) : String {
        // check for key in room
        Log.d("DEBUG", "search $room")
        val items = house.rooms[room.lowercase()]?.forEach {
            Log.d("DEBUG", "items in $room = ${it.key}")
        }

        if (house.rooms[room.lowercase()]?.contains("key") == true) {
            Log.d("DEBUG", "game won")
            return "You found the key, the fortune is yours!!"
        }
        else {
            return "Your search $room found nothing"
        }
    }

    /*****************************************
     *  Open door with sound
     *  https://codersguidebook.com/how-to-create-an-android-app/play-sounds-music-android-app
     ******************************************/
    fun openDoor(context: Context) {
        println("DEBUG: openDoor")

        try {
            if (mediaPlayer == null) {
                mediaPlayer = MediaPlayer.create(context, R.raw.door)
                mediaPlayer!!.isLooping = false
                mediaPlayer!!.start()
            }
            else mediaPlayer!!.start()
        }
        catch (e: Exception) {
            e.printStackTrace()
            println("DEBUG: mediaPlayer error")
        }
    }

    fun onDestroy() {
        //super.onDestroy()
        println("DEBUG: release mediaPlayer")
        mediaPlayer?.release()
        mediaPlayer = null
    }
}