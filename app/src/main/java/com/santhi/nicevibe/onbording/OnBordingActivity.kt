package com.santhi.nicevibe.onbording

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.santhi.nicevibe.auth.RegisterActivity
import com.santhi.nicevibe.auth.SignInActivity
import com.santhi.nicevibe.databinding.ActivityOnBordingBinding

class OnBordingActivity : AppCompatActivity() {
    private lateinit var binding:ActivityOnBordingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityOnBordingBinding.inflate(layoutInflater)
        binding.signIn.setOnClickListener {
            startActivity(Intent(this,SignInActivity::class.java))
        }
        binding.registerBtn.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
        setContentView(binding.root)


    }


}