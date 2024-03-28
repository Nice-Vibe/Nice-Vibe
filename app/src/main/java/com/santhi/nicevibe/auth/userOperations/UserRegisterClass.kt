package com.santhi.nicevibe.auth.userOperations

import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.santhi.nicevibe.MainActivity
import com.santhi.nicevibe.auth.UploadActivity
import com.santhi.nicevibe.loading.Loading
import com.santhi.nicevibe.localStorage.LocalStorage
import papaya.`in`.sendmail.SendMail
import kotlin.random.Random
import kotlin.random.nextInt

class UserRegisterClass(val context: Context){
    var random : Int=0
    val auth = FirebaseAuth.getInstance()
    fun createNewUser(email: String,password:String){
        Loading.showAlertDialogForLoading(context)

        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {

            if(it.isSuccessful){
                Loading.dismissDialogForLoading()
                val localStorage = LocalStorage(context)
                localStorage.saveString("email",email)
                context.startActivity(Intent(context,UploadActivity::class.java))
            }
            else {
                Loading.dismissDialogForLoading()
                val errorMessage = it.exception?.message ?: "Unknown error occurred"

                Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun sendOtp(email:String){
        val localStorage = LocalStorage(context)
        random= Random.nextInt(1000..9999)
        localStorage.saveString("otp",random.toString())
        var mail= SendMail("nicevibe1cr@gmail.com","fcvdhavotsvbmise",email,"Login Signup app's OTP",
            "Your OTP is -> $random")
        mail.execute()
    }
}