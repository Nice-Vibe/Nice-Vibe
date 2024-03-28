package com.santhi.nicevibe.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.santhi.nicevibe.R
import com.santhi.nicevibe.auth.userOperations.UserLoginClass
import com.santhi.nicevibe.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySignInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        supportActionBar?.hide()
        setContentView(binding.root)
        val userLoginClass = UserLoginClass(this)
        binding.verifyBtn.setOnClickListener {
            val email = binding.emailEt.text.toString()
            val  password = binding.passwordEt.text.toString()
            userLoginClass.loginUser(email,password)
        }

    }
}