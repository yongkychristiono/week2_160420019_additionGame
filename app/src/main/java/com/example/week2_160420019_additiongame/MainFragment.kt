package com.example.week2_160420019_additiongame

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import java.util.Random

class MainFragment : Fragment() {

    private lateinit var equationTextView: TextView
    private lateinit var answerEditText: EditText
    private lateinit var submitButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        equationTextView = view.findViewById(R.id.equationTextView)
        answerEditText = view.findViewById(R.id.answerEditText)
        submitButton = view.findViewById(R.id.submitButton)

        val random = Random()
        val num1 = random.nextInt(10) + 1
        val num2 = random.nextInt(10) + 1
        equationTextView.text = "$num1 + $num2 = "

        submitButton.setOnClickListener {
            val playerAnswer = answerEditText.text.toString().toIntOrNull()
            if (playerAnswer == num1 + num2) {
                // Correct answer
                // Add 1 point to the player's score
                // Navigate to the ResultFragment
            } else {
                // Incorrect answer
                // End the game and navigate to the ResultFragment
            }
        }

        return view
    }
}