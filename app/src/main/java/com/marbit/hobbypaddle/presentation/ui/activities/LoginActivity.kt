package com.marbit.hobbypaddle.presentation.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.marbit.hobbypaddle.R
import com.marbit.hobbypaddle.presentation.ui.activities.interfaces.LoginView
import android.content.Intent
import android.util.Log
import android.view.View
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.Task
import com.google.android.gms.common.api.ApiException
import com.marbit.hobbypaddle.di.application.ApplicationComponent
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity(), LoginView, View.OnClickListener {

    override fun onClick(p0: View?) {
        googleSignIn()
    }

    override fun setupComponent(appComponent: ApplicationComponent?) {

    }

    lateinit var mGoogleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        sign_in_button.setOnClickListener(this)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)

    }

    private val RC_SIGN_IN: Int = 99

    private fun googleSignIn() {
        val signInIntent = mGoogleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
        showMessage("HOLA")
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        }
    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            logInSuccess()
        } catch (e: ApiException) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.d("LOG", "signInResult:failed code=" + e.statusCode)
            loginError()
        }

    }

    private fun loginError() {


    }

    private fun logInSuccess() {
        startActivity(Intent(applicationContext, DashboardActivity::class.java))


    }
}
