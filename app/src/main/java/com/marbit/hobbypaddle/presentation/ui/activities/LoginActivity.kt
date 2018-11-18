package com.marbit.hobbypaddle.presentation.ui.activities

import android.os.Bundle
import com.marbit.hobbypaddle.R
import com.marbit.hobbypaddle.presentation.ui.activities.interfaces.LoginView
import android.content.Intent
import android.view.View
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.Task
import com.google.android.gms.common.api.ApiException

import com.marbit.hobbypaddle.di.application.ApplicationComponent
import com.marbit.hobbypaddle.di.component.DaggerLoginComponent
import com.marbit.hobbypaddle.di.modules.LoginModule
import com.marbit.hobbypaddle.presentation.presenters.LoginPresenter
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject


class LoginActivity : BaseActivity(), LoginView, View.OnClickListener {

    @Inject lateinit var presenter: LoginPresenter
    private val RC_SIGN_IN_CODE: Int = 99

    override fun setupComponent(appComponent: ApplicationComponent?) {}

    lateinit var mGoogleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        DaggerLoginComponent.builder()
                .loginModule(LoginModule(this))
                .build()
                .inject(this)
        this.initView()
    }


    private fun initView() {
        sign_in_button.setOnClickListener(this)
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()
        // client ID : 354364171690-ueol7giddu93ipbqt1euhuu128hc0tqu.apps.googleusercontent.com
        // CLient secret: Y7YlWhAGCdeEdxrQiorrh0wH
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)
    }

    override fun onClick(p0: View?) {
        presenter.clickLoginButton()
    }

    override fun googleSignIn() {
        val signInIntent = mGoogleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN_CODE)
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN_CODE) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            presenter.logInSuccess(account)
        } catch (e: ApiException) {
            presenter.loginError(e)
        }
    }

    override fun loginError(error: String?) {
        showMessage(error ?: "Login Error")
    }

    override fun logInSuccess() {
        startActivity(Intent(applicationContext, DashboardActivity::class.java))
    }

    fun clickTest(view: View){
        startActivity(Intent(applicationContext, CalendarTestActivity::class.java))
    }
}
