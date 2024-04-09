package com.santhi.nicevibe.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.database
import com.santhi.nicevibe.MainActivity
import com.santhi.nicevibe.R
import com.santhi.nicevibe.databinding.ActivitySignUpBinding
import com.santhi.nicevibe.databinding.ActivityUploadBinding
import com.santhi.nicevibe.fcm.TokenManager
import com.santhi.nicevibe.localStorage.LocalStorage
import com.santhi.nicevibe.model.UserModel

class UploadActivity : AppCompatActivity() {
    private lateinit var binding:ActivityUploadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUploadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val tokenManager = TokenManager(this)

        tokenManager.getSavedToken()
        val notificationID = tokenManager.getSavedToken()
        val localStorage = LocalStorage(this)
        val email = localStorage.getString("email")
        val gender = localStorage.getString("gender")
        val college = localStorage.getString("college")
        val userName = localStorage.getString("userName")
        val year = localStorage.getString("year")
        val branch = localStorage.getString("branch")
        val section = localStorage.getString("sec")
        val profile = localStorage.getString("profile")

        val uid = FirebaseAuth.getInstance().currentUser?.uid
        val userModel = UserModel(userName,gender,college,year,branch,section,uid,notificationID,profile)
        val roomId = year+branch+section
        Firebase.database("https://nice-vibe-d2471-default-rtdb.asia-southeast1.firebasedatabase.app/").reference.child("users").child(college).child(roomId).child(uid.toString()).setValue(userModel).addOnCompleteListener {
            if (it.isSuccessful){
                Toast.makeText(this, "Sucess", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,MainActivity::class.java))
            }else{
                Toast.makeText(this, "Some thing error", Toast.LENGTH_SHORT).show()
            }
        }

    }
}