package com.marbit.hobbypaddle.domain.presenters

import com.marbit.hobbypaddle.presentation.presenters.MenuPresenter
import com.marbit.hobbypaddle.presentation.ui.fragments.interfaces.MenuView


class MenuPresenterImpl(private val view: MenuView): MenuPresenter {


    override fun clickLogOut() {
        view.clickLogOut()
    }
}