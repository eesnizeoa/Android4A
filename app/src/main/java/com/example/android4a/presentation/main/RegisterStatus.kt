package com.example.android4a.presentation.main

sealed class RegisterStatus

data class RegisterSuccess(val email: String, val password: String) : RegisterStatus()
object RegisterError : RegisterStatus()