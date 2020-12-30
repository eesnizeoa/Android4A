package com.example.android4a.presentation.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import com.example.MainViewModel
import com.example.android4a.R
import com.example.android4a.domain.entity.User
import com.example.android4a.domain.usecase.CreateUserUseCase
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_create_account.*
import org.koin.android.ext.android.inject
import java.util.Observer

class CreateAccountActivity: AppCompatActivity() {

    val createaccountViewModel : CreateAccountViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)

        createaccountViewModel.registerLiveData.observe(this, androidx.lifecycle.Observer {
            when(it){
                is RegisterSuccess -> {
                    val intent: Intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                }
                RegisterError -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Problème")
                        .setMessage("Veuillez vérifier vos champs")
                        .setPositiveButton("OK"){ dialog, which -> dialog.dismiss()}
                        .show()
                }
            }
        })

        register_button.setOnClickListener{
            createaccountViewModel.onClickedRegister(login_edit.text.toString().trim(),password_edit.text.toString().trim())
        }

    }
}