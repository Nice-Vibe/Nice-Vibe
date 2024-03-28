package com.santhi.nicevibe.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.santhi.nicevibe.R
import com.santhi.nicevibe.databinding.ActivitySelectClassBinding
import com.santhi.nicevibe.localStorage.LocalStorage

class SelectClassActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySelectClassBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectClassBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val localStorage = LocalStorage(this)



        binding.verifyBtn.setOnClickListener {
            // Retrieve selected items from spinners
            val selectYear = binding.batchSpinner.selectedItem.toString()
            val selectBranch = binding.branchSpinner.selectedItem.toString()
            val selectSection = binding.sections.selectedItem.toString()

            // Check if any of the selections are not made
            if (selectYear == "Select your passout year") {
                showToast("Select year")
                return@setOnClickListener
            }
            if (selectBranch == "Select your branch") {
                showToast("Select branch")
                return@setOnClickListener
            }
            if (selectSection == "Select your section") {
                showToast("Select section")
                return@setOnClickListener
            }

            // All selections are valid, proceed to save them
            localStorage.saveString("year", selectYear)
            localStorage.saveString("branch", selectBranch)
            localStorage.saveString("sec", selectSection)
            startActivity(Intent(this,SignUpActivity::class.java))
        }
    }
    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}