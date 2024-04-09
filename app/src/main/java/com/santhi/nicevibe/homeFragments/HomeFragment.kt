package com.santhi.nicevibe.homeFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.santhi.nicevibe.R
import com.santhi.nicevibe.databinding.FragmentHomeBinding

// two list required
// #1 polls
// #2 class
// #3 friends
class HomeFragment : Fragment() {
  private lateinit var binding:FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)

        return binding.root
    }


}