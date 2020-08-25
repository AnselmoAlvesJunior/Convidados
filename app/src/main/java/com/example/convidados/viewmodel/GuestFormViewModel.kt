package com.example.convidados.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.convidados.service.repository.model.GuestModel
import com.example.convidados.service.repository.GuestRepository

class GuestFormViewModel  : ViewModel(){

    private var mGuestRepository: GuestRepository =
        GuestRepository()

    private var mSaveGuest=MutableLiveData<Boolean>()
    val saveGuest:LiveData<Boolean> = mSaveGuest

    fun save(name:String,presence: Boolean){
        val guest= GuestModel(name, presence)
        mGuestRepository.save(guest)
    }
}