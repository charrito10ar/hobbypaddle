package com.marbit.hobbypaddle;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.UiThread;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.support.v7.app.AppCompatDelegate;

import com.marbit.hobbypaddle.di.application.ApplicationComponent;
import com.marbit.hobbypaddle.di.application.ApplicationModule;
import com.marbit.hobbypaddle.di.application.DaggerApplicationComponent;
import com.marbit.hobbypaddle.di.component.DaggerNetComponent;
import com.marbit.hobbypaddle.di.component.NetComponent;

import javax.inject.Inject;

public class BaseApplication extends MultiDexApplication {

    @Inject
    SharedPreferences mPreferences;

    private ApplicationComponent applicationComponent;

    private NetComponent mNetComponent;
    private static BaseApplication app;

    public static BaseApplication get(Context context) {
        return (BaseApplication) context.getApplicationContext();
    }

    public static BaseApplication getApp() {
        return app;
    }


    @Override
    public void onCreate() {
        getApplicationComponent().inject(this);
        super.onCreate();
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        app = this;
    }

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }

    @UiThread
    public ApplicationComponent getApplicationComponent(){
        if(applicationComponent == null){
            applicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
        }
        return applicationComponent;
    }


    public NetComponent getNetComponent() {
        if(mNetComponent == null){
            mNetComponent = DaggerNetComponent.create();
        }
        return mNetComponent;
    }


    public SharedPreferences getSharedPreferences() {
        return mPreferences;
    }

}