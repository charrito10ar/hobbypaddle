package com.marbit.hobbypaddle.di.component;

import com.marbit.hobbypaddle.di.ActivityScope;
import com.marbit.hobbypaddle.di.modules.LoginModule;
import com.marbit.hobbypaddle.presentation.presenters.LoginPresenter;
import com.marbit.hobbypaddle.presentation.ui.activities.LoginActivity;
import com.marbit.hobbypaddle.presentation.ui.activities.interfaces.LoginView;

import dagger.Component;

@ActivityScope
@Component(modules = {LoginModule.class})
public interface LoginComponent {
    void inject(LoginActivity loginActivity);
    LoginView getLoginView();
    LoginPresenter getPresenter();
}
