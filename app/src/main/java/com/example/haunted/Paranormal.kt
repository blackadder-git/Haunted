package com.example.haunted

data class Paranormal (val ghost: String = "Slimer") {

    // list
    val sounds: List<String> = listOf<String>(
        "A creaking door suddenly slams shut",
        "Are those footsteps?",
        "Static ... tschhhhhhhhhhhhhh, did the TV just turn on?",
        "Something scurries behind the wall",
        "Glass smashes!",
        "GET OUT! whispers a voice behind you",
        "Soft laughter grows louder and then suddenly stops",
        "In the distance, you hear a scream for help"
    )

    // set
    val sights: Set<String> = setOf<String>(
        "The house lights begin to flicker on and off",
        "Was that? Yes, you just walked into a cobweb",
        "Did it just get cold in here?"
    )

    // map (dictionary)
    val smells: Map<Int, String> = mapOf(
        1 to "The house lights begin to flicker on and off",
        2 to "Pipe tobacco? Uncle Pineda doesn't smoke!",
        3 to "The scent of jasmine perfume floats by as if someone just crossed your path",
        4 to "Is that rancid food?"
    )
}