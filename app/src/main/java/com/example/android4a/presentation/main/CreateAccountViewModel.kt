package com.example.android4a.presentation.main

import com.example.android4a.presentation.main.RegisterError
import com.example.android4a.presentation.main.RegisterStatus
import com.example.android4a.presentation.main.RegisterSuccess
import kotlinx.coroutines.withContext

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android4a.domain.entity.User
import com.example.android4a.domain.usecase.CreateUserUseCase
import com.example.android4a.domain.usecase.GetUserUseCase
import kotlinx.android.synthetic.main.activity_create_account.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CreateAccountViewModel(
    private val createUserUseCase: CreateUserUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    val registerLiveData: MutableLiveData<RegisterStatus> = MutableLiveData()

    fun onClickedRegister(emailRegister: String, passwordRegister: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val registerStatus : RegisterStatus? = if (emailRegister != null && passwordRegister != null) {
                createUserUseCase.invoke(user= User(emailRegister,passwordRegister))
                RegisterSuccess(emailRegister, passwordRegister)
            } else {
                RegisterError
            }
            withContext(Dispatchers.Main) {
                registerLiveData.value = registerStatus
            }
        }
    }
}