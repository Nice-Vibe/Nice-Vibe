package com.santhi.nicevibe.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.santhi.nicevibe.databinding.PollItemLayoutBinding
import com.santhi.nicevibe.model.PollModel
import com.santhi.nicevibe.model.UserModel

class PollAdapter(val context: Context, val pollList:ArrayList<String>,val classList: List<UserModel>,val friendsList:List<UserModel>
):RecyclerView.Adapter<PollAdapter.ViewHolder>() {
    inner  class  ViewHolder(val binding:PollItemLayoutBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(PollItemLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return pollList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}