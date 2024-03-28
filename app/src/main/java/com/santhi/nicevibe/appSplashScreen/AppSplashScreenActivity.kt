package com.santhi.nicevibe.appSplashScreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.santhi.nicevibe.R
import com.santhi.nicevibe.onbording.OnBordingActivity


// AppSplashScreenActivity is responsible for displaying the splash screen of the application.
class AppSplashScreenActivity : AppCompatActivity() {

    // This method is called when the activity is first created.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Hide the action bar at the top of the screen.
        supportActionBar?.hide()

        // Set the layout of the activity to the specified XML layout resource.
        setContentView(R.layout.activity_app_splash_screen)

        // A Handler allows you to send and process Runnable objects associated with a thread's message queue.
        // Here, it posts a delayed action to start the MainActivity after 1000 milliseconds (1 second).
        Handler(mainLooper).postDelayed({
            // Create an Intent to start the MainActivity.
            val intent = Intent(this, OnBordingActivity::class.java)
            // Start the MainActivity.
            startActivity(intent)
            // Finish the current activity so that it's removed from the back stack.
            finish()
        }, 1000) // 1000 milliseconds delay
    }
}
