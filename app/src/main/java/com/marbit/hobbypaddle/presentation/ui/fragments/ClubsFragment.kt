package com.marbit.hobbypaddle.presentation.ui.fragments

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.*

import com.marbit.hobbypaddle.R
import android.view.MenuInflater
import com.marbit.hobbypaddle.presentation.ui.fragments.interfaces.ClubsView
import android.widget.Toast
import com.marbit.hobbypaddle.di.component.DaggerClubsFragmentComponent
import com.marbit.hobbypaddle.di.modules.ClubsFragmentModule
import com.marbit.hobbypaddle.domain.model.Court
import com.marbit.hobbypaddle.presentation.presenters.ClubsPresenter
import com.marbit.hobbypaddle.presentation.ui.adapters.ClubsAdapter
import kotlinx.android.synthetic.main.fragment_clubs.*
import javax.inject.Inject


class ClubsFragment : BaseFragment(), ClubsView {

    @Inject lateinit var presenter: ClubsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_clubs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DaggerClubsFragmentComponent.builder().clubsFragmentModule(ClubsFragmentModule(this)).build().inject(this)
        initView()
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.clubs_fragment_menu, menu)
    }

    override fun initView() {
        recycler_view_courts.layoutManager = LinearLayoutManager(context)
        var adapter = ClubsAdapter(){
            Toast.makeText(context, "${it.description} Clicked", Toast.LENGTH_LONG).show()
        }
        var list: MutableList<Court> = ArrayList()
        var elemento = Court(ArrayList(), "Marcelo", 2.0, 2)
        list.add(elemento)
        list.add(Court(ArrayList(), "Manuel", 2.0, 2))
        list.add(Court(ArrayList(), "Juan", 2.0, 2))
        recycler_view_courts.adapter = adapter
        adapter.setList(list)
        adapter.notifyDataSetChanged()
        presenter.getClubs()
    }

}
