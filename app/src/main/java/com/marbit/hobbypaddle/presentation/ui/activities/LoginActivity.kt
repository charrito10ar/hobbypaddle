package com.marbit.hobbypaddle.presentation.ui.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.marbit.hobbypaddle.R
import com.marbit.hobbypaddle.presentation.ui.interfaces.LoginView

class LoginActivity : AppCompatActivity(), LoginView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
}
