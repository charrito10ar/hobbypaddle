package com.marbit.hobbypaddle.presentation.ui.activities.interfaces

interface LoginView {
    fun googleSignIn()
    fun logInSuccess()
    fun loginError(localizedMessage: String?)
}