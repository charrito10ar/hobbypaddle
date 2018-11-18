package com.marbit.hobbypaddle.presentation.ui.fragments;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.Spanned;
import android.widget.Toast;

import com.marbit.hobbypaddle.BaseApplication;
import com.marbit.hobbypaddle.R;
import com.marbit.hobbypaddle.presentation.ui.activities.interfaces.BaseView;


public abstract class BaseFragment extends Fragment implements BaseView {

    @Override
    public void showMessage(@NonNull String message){ Toast.makeText(BaseApplication.getApp().getApplicationContext(), message, Toast.LENGTH_SHORT).show(); }

    @Override
    public void onUnknownError(){  showMessage(getString(R.string.ERROR_UNKOWN));}
    @Override
    public void onTimeout(){ showMessage(getString(R.string.ERROR_TIME_OUT)); }
    @Override
    public void onNetworkError(){showMessage(getString(R.string.ERROR_NETWORK_CONNECTION)); }
    @Override
    public void serverUnavailable(){ showMessage(getString(R.string.ERROR_SERVER_TEMPORARILY_UNAVAILABLE)); }
    @Override
    public void showProgress(){}
    @Override
    public void hideProgress(){}

    @Override
    public void showMessageError(String message){
        showMessage(message);
    }
    @Override
    public void serverError(){
        showMessage("Server eroor");
    }

    protected Spanned fromHtmlToString(String text){
        Spanned spanned;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            spanned = Html.fromHtml(text, Html.FROM_HTML_MODE_COMPACT);
        } else {
            spanned = Html.fromHtml(text);
        }
        return spanned;
    }
}