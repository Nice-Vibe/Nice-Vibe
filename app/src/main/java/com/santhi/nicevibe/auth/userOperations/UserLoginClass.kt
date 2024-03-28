package com.santhi.nicevibe.auth.userOperations

import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.santhi.nicevibe.MainActivity
import com.santhi.nicevibe.loading.Loading.dismissDialogForLoading
import com.santhi.nicevibe.loading.Loading.showAlertDialogForLoading
import com.santhi.nicevibe.localStorage.LocalStorage

class UserLoginClass(val context:Context) {
    val auth = FirebaseAuth.getInstance()
    fun loginUser(email:String,password:String){
        showAlertDialogForLoading(context)
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
            if (it.isSuccessful){
                val localStorage = LocalStorage(context)
                localStorage.saveString("email",email)
                dismissDialogForLoading()
                Toast.makeText(context, "Good job!", Toast.LENGTH_SHORT).show()
                context.startActivity(Intent(context,MainActivity::class.java))
            }else{
                dismissDialogForLoading()
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
            }
        }
    }
}