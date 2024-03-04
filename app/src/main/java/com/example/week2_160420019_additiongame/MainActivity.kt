package com.example.week2_160420019_additiongame

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.week2_160420019_additiongame.ui.theme.Week2_160420019_additionGameTheme

private val MainActivity.ActivityMainBinding.root: Any
    get() {
        TODO("Not yet implemented")
    }

class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding

    class ActivityMainBinding {
        companion object {
            fun inflate(layoutInflater: LayoutInflater): ActivityMainBinding {

            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Check if the activity is being re-initialized after a configuration change
        if (savedInstanceState == null) {
            // Add the MainFragment to the fragment container
            val supportFragmentManager = null
            val commit = supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, MainFragment())
                .commit()
        }

        // Set the click listener for the button in the ResultFragment
        binding.resultFragment.backToMainButton.setOnClickListener {
            // Replace the ResultFragment with the MainFragment
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, MainFragment())
                .commit()
        }
    }

    // Function to replace the current fragment with a new one
    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}