package com.example.android4a.presentation.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.MainViewModel
import com.example.android4a.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val mainViewModel : MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel.loginLiveData.observe(this, Observer {
            when(it){
                is LoginSuccess -> {
                    val intent: Intent = Intent(this,ListAppActivity::class.java)
                    startActivity(intent)
                }
                LoginError -> {
                    MaterialAlertDialogBuilder(this)
                        .setTitle("Compte Inconnu")
                        .setMessage("Le mot de passe est erroné ou le compte n'existe pas\nVeuilez vérifier votre mot de passe ou créer un compte !")
                        .setPositiveButton("OK"){ dialog, which -> dialog.dismiss()}
                        .show()
                }
            }
        })
        login_button.setOnClickListener{
            mainViewModel.onClickedLogin(login_edit.text.toString().trim(),password_edit.text.toString().trim())
        }
        create_account_button.setOnClickListener{
            //setContentView(R.layout.create_account)
            val intent: Intent = Intent(this,CreateAccountActivity::class.java)
            startActivity(intent)
        }
    }
}
