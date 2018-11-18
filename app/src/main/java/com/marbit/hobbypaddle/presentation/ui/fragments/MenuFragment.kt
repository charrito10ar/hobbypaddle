package com.marbit.hobbypaddle.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.marbit.hobbypaddle.R
import com.marbit.hobbypaddle.di.component.DaggerMenuComponent
import com.marbit.hobbypaddle.di.modules.MenuModule
import com.marbit.hobbypaddle.presentation.presenters.MenuPresenter
import com.marbit.hobbypaddle.presentation.ui.fragments.interfaces.MenuView
import kotlinx.android.synthetic.main.fragment_menu_list.*
import javax.inject.Inject

class MenuFragment : BaseFragment(), MenuView {

    @Inject lateinit var presenter: MenuPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_menu_list, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DaggerMenuComponent.builder().menuModule(MenuModule(this)).build().inject(this)
        initView()
    }

    private fun initView() {
        option_menu_log_out.setOnClickListener { presenter.clickLogOut() }
    }

    override fun clickLogOut() {

        showMessage("Log Out")
    }
}
