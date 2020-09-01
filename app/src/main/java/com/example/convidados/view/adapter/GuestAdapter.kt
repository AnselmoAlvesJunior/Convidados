package com.example.convidados.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.convidados.R
import com.example.convidados.service.model.GuestModel
import com.example.convidados.view.viewholder.GuestViewHolder

class GuestAdapter : RecyclerView.Adapter<GuestViewHolder>() {

    private var mGuestList:List<GuestModel> = arrayListOf()

    companion object{
        var createCount: Int=0
        var bindCount: Int=0
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestViewHolder {
        createCount++
        val item=LayoutInflater.from(parent.context).inflate(R.layout.row_guest,parent,false)
        return GuestViewHolder(item)
    }

    override fun getItemCount(): Int {
        return mGuestList.count()
    }

    override fun onBindViewHolder(holder: GuestViewHolder, position: Int) {
        bindCount++
        holder.bind(mGuestList[position])
    }
    fun updateGuests(list: List<GuestModel>){
        mGuestList= list
        notifyDataSetChanged()

    }
}