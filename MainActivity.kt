/*
Course: MAD 302
Lab: Lab1
Name: Jennyfer Parmar
Student ID: A00201240
Date: 13 February 2026
Description:
This app allows users to add profiles with name and age and display them in a TextView.
*/

package com.example.lab1_mad301_jennyfer

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/*
Main activity that handles user input and displays profiles.
*/
class MainActivity : AppCompatActivity() {

    // List storing all entered profiles
    private val profileList = mutableListOf<Profile>()

    /*
    Called when activity is first created.
    Sets layout, initializes views and button logic.
    */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Lifecycle log for debugging
        Log.d("Lifecycle", "onCreate called")

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Apply padding to prevent overlap with system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Input fields for name and age
        val nameInput: EditText = findViewById(R.id.nameEditText)
        val ageInput: EditText = findViewById(R.id.ageEditText)

        // Button to add a new profile
        val addButton: Button = findViewById(R.id.addButton)

        // TextView used to display profile list
        val displayTextView: TextView = findViewById(R.id.profileTextView)

        // Runs when Add button is clicked
        addButton.setOnClickListener {

            // Read input values from fields
            val name = nameInput.text.toString().trim()
            val ageString = ageInput.text.toString().trim()

            // Add profile only if inputs are not empty
            if (name.isNotEmpty() && ageString.isNotEmpty()) {

                val age = ageString.toInt()

                // Add profile object to list
                profileList.add(Profile(name, age))

                // Update TextView with all profiles
                updateDisplay(displayTextView)

                // Clear input fields for next entry
                nameInput.text.clear()
                ageInput.text.clear()
            }
        }
    }

    /*
    Formats profile list and displays it in TextView.
    */
    private fun updateDisplay(textView: TextView) {
        val sb = StringBuilder()

        // Loop through profile list and append details
        for (profile in profileList) {
            sb.append("Name: ${profile.name}, Age: ${profile.age}\n")
            sb.append("----------------------------\n")
        }

        // Set formatted text to TextView
        textView.text = sb.toString()
    }

    /*
    Lifecycle method called when activity becomes visible.
    */
    override fun onStart() {
        super.onStart()
        // Lifecycle log
        Log.d("Lifecycle", "onStart called")
    }

    /*
    Lifecycle method called when activity starts interaction.
    */
    override fun onResume() {
        super.onResume()
        // Lifecycle log
        Log.d("Lifecycle", "onResume called")
    }

    /*
    Lifecycle method called when activity is partially hidden.
    */
    override fun onPause() {
        super.onPause()
        // Lifecycle log
        Log.d("Lifecycle", "onPause called")
    }

    /*
    Lifecycle method called when activity is no longer visible.
    */
    override fun onStop() {
        super.onStop()
        // Lifecycle log
        Log.d("Lifecycle", "onStop called")
    }

    /*
    Lifecycle method called before activity is destroyed.
    */
    override fun onDestroy() {
        super.onDestroy()
        // Lifecycle log
        Log.d("Lifecycle", "onDestroy called")
    }
}
