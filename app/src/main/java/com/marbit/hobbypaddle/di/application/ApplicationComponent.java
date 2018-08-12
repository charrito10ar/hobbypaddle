package com.marbit.hobbypaddle.di.application;

import android.app.Application;
import android.content.SharedPreferences;

import com.marbit.hobbypaddle.BaseApplication;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(BaseApplication application);

    Application application();
    SharedPreferences sharedPreferences();

}