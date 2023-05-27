package com.example.haunted

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Test.newInstance] factory method to
 * create an instance of this fragment.
 */
class Test : Fragment() {
    // TODO: Rename and change types of parameters
    // private var param1: String? = null
    // private var param2: String? = null

    /*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }
    */

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {





        // https://johncodeos.com/how-to-pass-data-between-fragments-in-android-using-kotlin/
        // https://www.tutorialspoint.com/send-data-from-one-fragment-to-another-using-kotlin
        // create view
        val fragmentView = inflater.inflate(R.layout.fragment_test, container, false)
        val health = arguments?.getString("hp")
        val room = arguments?.getString("room")

        fragmentView.findViewById<TextView>(R.id.hpFrag).text = health

        // go to settings
        val settings = fragmentView.findViewById<ImageView>(R.id.gearFrag)
        settings.setOnClickListener {

            // create a new activity from inside a fragment
            // https://stackoverflow.com/questions/53355786/kotlin-open-new-activity-inside-of-a-fragment
            Log.d("DEBUG:", "show settings")
            val intent = Intent (activity, Settings::class.java)
            intent.putExtra("roomKey", room)
            activity?.startActivity(intent)
        }

        return fragmentView
    }

    /*
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment test.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            test().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    */
}