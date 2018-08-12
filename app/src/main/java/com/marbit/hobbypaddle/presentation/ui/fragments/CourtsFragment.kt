package com.marbit.hobbypaddle.presentation.ui.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.*

import com.marbit.hobbypaddle.R
import android.view.MenuInflater
import com.marbit.hobbypaddle.presentation.ui.fragments.interfaces.CourtsView
import android.widget.Toast
import com.marbit.hobbypaddle.domain.model.Court
import com.marbit.hobbypaddle.presentation.ui.adapters.CourtAdapter
import kotlinx.android.synthetic.main.fragment_curts.*


class CourtsFragment : Fragment(), CourtsView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_curts, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.courts_fragment_menu, menu)
    }

    override fun initView() {
        recycler_view_courts.layoutManager = LinearLayoutManager(context)
        var adapter = CourtAdapter(){
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
    }


}
