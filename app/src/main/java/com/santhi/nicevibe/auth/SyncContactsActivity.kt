package com.santhi.nicevibe.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.santhi.nicevibe.R
import com.santhi.nicevibe.databinding.ActivitySyncContactsBinding

class SyncContactsActivity : AppCompatActivity() {
    private lateinit var binding:ActivitySyncContactsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySyncContactsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}