package com.marbit.hobbypaddle.presentation.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.marbit.hobbypaddle.R
import com.marbit.hobbypaddle.domain.model.Court
import kotlinx.android.synthetic.main.court_item.view.*

class CourtAdapter(private val listener: (Court) -> Unit) : RecyclerView.Adapter<CourtAdapter.CourtViewHolder>(){

    private var courtList: MutableList<Court> = ArrayList()

    override fun onBindViewHolder(holder: CourtViewHolder?, position: Int) = holder!!.bind(courtList[position], listener)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CourtViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.court_item, parent, false))

    override fun getItemCount(): Int {
        return courtList.size
    }

    fun setList(list: MutableList<Court>) {
        courtList.addAll(list)
    }

    class CourtViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(court: Court, listener: (Court) -> Unit) = with(itemView) {
            description.text = court.description
            setOnClickListener { listener(court) }
        }
    }
}