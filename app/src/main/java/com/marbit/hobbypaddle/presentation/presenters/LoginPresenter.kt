package com.marbit.hobbypaddle.presentation.presenters

import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.common.api.ApiException

interface LoginPresenter {
    fun clickLoginButton()
    fun logInSuccess(account: GoogleSignInAccount?)
    fun loginError(e: ApiException)
}
