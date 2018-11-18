package com.marbit.hobbypaddle.di.modules;

import com.marbit.hobbypaddle.di.ActivityScope;
import com.marbit.hobbypaddle.domain.presenters.LoginPresenterImpl;
import com.marbit.hobbypaddle.presentation.presenters.LoginPresenter;
import com.marbit.hobbypaddle.presentation.ui.activities.interfaces.LoginView;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

    private LoginView view;

    public LoginModule(LoginView view){
        this.view = view;
    }

    @Provides
    @ActivityScope
    public LoginView provideView(){
        return view;
    }

    @Provides
    @ActivityScope
    public LoginPresenter providePresenter(LoginView view){
        return new LoginPresenterImpl(view);
    }
}
