package com.marbit.hobbypaddle.presentation.ui.activities.interfaces

interface BaseView{
    fun showMessage(message: String)
    fun showMessageError(message: String)
    fun onUnknownError()
    fun onTimeout()
    fun onNetworkError()
    fun serverError()
    fun serverUnavailable()
    fun showProgress()
    fun hideProgress()
}