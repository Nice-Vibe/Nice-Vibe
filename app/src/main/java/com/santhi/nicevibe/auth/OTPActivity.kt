package com.santhi.nicevibe.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.santhi.nicevibe.auth.userOperations.UserRegisterClass
import com.santhi.nicevibe.databinding.ActivityOtpactivityBinding
import com.santhi.nicevibe.localStorage.LocalStorage

class OTPActivity : AppCompatActivity() {
    private lateinit var binding:ActivityOtpactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtpactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val localStorage = LocalStorage(this)
        val getEmail = localStorage.getString("email")
        val userRegisterClass = UserRegisterClass(this)


        binding.openMail.setOnClickListener {
            openGmail()
        }
        binding.verifyBtn.setOnClickListener {
            val otp = localStorage.getString("otp")
            val getOtpET = binding.otpEt.text.toString()
            if (otp == getOtpET){
                startActivity(Intent(this,PasswordActivity::class.java))
            }else{
                Toast.makeText(this, "$otp == $getOtpET", Toast.LENGTH_SHORT).show()
            }

        }
        binding.tvResend.setOnClickListener {
            Toast.makeText(this, "otp is sent", Toast.LENGTH_SHORT).show()
         userRegisterClass.sendOtp(getEmail)
        }


    }

    // Function to check if a package is installed

    private fun openGmail() {
        val intent = packageManager.getLaunchIntentForPackage("com.google.android.gm")

        if (intent != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "Gmail app not installed", Toast.LENGTH_SHORT).show()
        }

    }
}