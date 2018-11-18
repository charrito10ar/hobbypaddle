package com.marbit.hobbypaddle.domain.presenters

import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.common.api.ApiException
import com.marbit.hobbypaddle.presentation.presenters.LoginPresenter
import com.marbit.hobbypaddle.presentation.ui.activities.interfaces.LoginView

class LoginPresenterImpl(private val view: LoginView) : LoginPresenter {

    override fun loginError(e: ApiException) {
        view.loginError(e.localizedMessage)
    }

    override fun logInSuccess(account: GoogleSignInAccount?) {
        view.logInSuccess()
    }

    override fun clickLoginButton() {
        view.googleSignIn()
    }
}