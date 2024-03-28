package com.santhi.nicevibe.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.santhi.nicevibe.auth.userOperations.UserRegisterClass
import com.santhi.nicevibe.databinding.ActivityPasswordBinding
import com.santhi.nicevibe.localStorage.LocalStorage

class PasswordActivity : AppCompatActivity() {
    private lateinit var binding:ActivityPasswordBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val userRegisterClass = UserRegisterClass(this)
        val  localStorage = LocalStorage(this)
        val  getEmail = localStorage.getString("email")
        binding.verifyBtn.setOnClickListener {
            val password = binding.passwordEt.text.toString()

            userRegisterClass.createNewUser(getEmail,password)


        }
    }
}