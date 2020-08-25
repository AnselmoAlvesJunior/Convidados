package com.example.convidados.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.convidados.viewmodel.GuestFormViewModel
import com.example.convidados.R
import kotlinx.android.synthetic.main.activity_guest_form.*

class GuestFormActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewModel: GuestFormViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_form)

        mViewModel=ViewModelProvider(this).get(GuestFormViewModel::class.java)
        setListeners()
        observe()
    }

    private fun setListeners(){
        btn_save.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        val id= v?.id
        if (id== R.id.btn_save){
            val name= edit_nome.text.toString()
            val presence=radio_presence.isChecked
            mViewModel.save(name,presence)
        }
    }

    private fun observe(){
        mViewModel.saveGuest.observe(this, Observer {
         if(it) {
             Toast.makeText(applicationContext, "Sucesso!!", Toast.LENGTH_SHORT).show()
         }
            else{
             Toast.makeText(applicationContext, "Falhou!!", Toast.LENGTH_SHORT).show()

         }
        })
    }

}