package com.marbit.hobbypaddle.presentation.ui.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.marbit.hobbypaddle.BaseApplication;
import com.marbit.hobbypaddle.di.application.ApplicationComponent;
import com.marbit.hobbypaddle.presentation.ui.activities.interfaces.BaseView;

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupComponent(BaseApplication.get(this).getApplicationComponent());
    }

    protected abstract void setupComponent(ApplicationComponent appComponent);

    @Override
    public void showMessage(@NonNull String message){ Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();}
    @Override
    public void showMessageError(@NonNull String message){Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();}
    @Override
    public void onUnknownError(){ Toast.makeText(getApplicationContext(), "Error desconocio", Toast.LENGTH_SHORT).show(); }
    @Override
    public void onTimeout(){ Toast.makeText(getApplicationContext(), "Error de Time Out", Toast.LENGTH_SHORT).show(); }
    @Override
    public void onNetworkError(){}
    @Override
    public void serverUnavailable(){ Toast.makeText(getApplicationContext(), "Servicio no disponible", Toast.LENGTH_SHORT).show(); }
    @Override
    public void showProgress(){}
    @Override
    public void hideProgress(){}
    @Override
    public void serverError(){ Toast.makeText(getApplicationContext(), "Error en el servidor", Toast.LENGTH_SHORT).show(); }
}