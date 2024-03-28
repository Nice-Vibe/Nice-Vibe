package com.santhi.nicevibe.auth
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.santhi.nicevibe.databinding.ActivityRegisterBinding
import com.santhi.nicevibe.localStorage.LocalStorage

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflating layout using view binding
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Creating instance of LocalStorage class
        val localStorage = LocalStorage(this)

        // Setting click listener for the 'Next' button
        binding.next.setOnClickListener {
            val name = binding.nameEt.text.toString()
            val gender = binding.gender.selectedItem.toString()
            val college = binding.college.selectedItem.toString()

            if (validateInputs(name, gender, college)) {
                // Saving user details to local storage
                localStorage.saveString("userName", name)
                localStorage.saveString("gender", gender)
                localStorage.saveString("college", college)

                // Starting MainActivity after registration
                startActivity(Intent(this, SelectClassActivity::class.java))
            }
        }
    }

    private fun validateInputs(name: String, gender: String, college: String): Boolean {
        if (name.trim().length < 4) {
            showToast("Enter your full name")
            return false
        }

        if (gender == "Select Gender") {
            showToast("Select Gender")
            return false
        }
        if (college == "Select your college") {
            showToast("Select your college")
            return false
        }
        return true
    }


    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
