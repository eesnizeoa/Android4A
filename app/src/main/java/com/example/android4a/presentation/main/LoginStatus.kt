package com.example.android4a.presentation.main

sealed class LoginStatus

data class LoginSuccess(val email: String, val password: String) : LoginStatus()
object LoginError : LoginStatus()