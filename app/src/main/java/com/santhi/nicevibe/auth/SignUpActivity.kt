package com.santhi.nicevibe.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.santhi.nicevibe.auth.userOperations.UserRegisterClass
import com.santhi.nicevibe.databinding.ActivitySignUpBinding
import com.santhi.nicevibe.localStorage.LocalStorage

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val userRegisterClass = UserRegisterClass(this)

        binding.verifyBtn.setOnClickListener {
            val email = binding.signupEmail.text.toString()


            // Check if email contains the required domain
            if (!email.endsWith("@anits.edu.in")) {
                Toast.makeText(this, "Email must be from @anits.edu.in domain", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            userRegisterClass.sendOtp(email)
            startActivity(Intent(this,OTPActivity::class.java))



        }





    }
}