package com.sehatin.sehatin

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AktAdapter : RecyclerView.Adapter<AktViewHolder>() {

    private val aktivitas = ArrayList<Aktivitas>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AktViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return AktViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: AktViewHolder, position: Int) {
        val aktivitas: Aktivitas = aktivitas[position]
        holder.bind(aktivitas)
    }

    override fun getItemCount(): Int = aktivitas.size

    fun setData(datas: List<Aktivitas>) {
        aktivitas.clear()
        aktivitas.addAll(datas)
        notifyDataSetChanged()
    }

    fun moveItem(from: Int, to: Int) {
        val fromLocation = aktivitas[from]
        aktivitas.removeAt(from)

        if (to < from)
            aktivitas.add(to + 1, fromLocation)
        else
            aktivitas.add(to - 1, fromLocation)
    }

    fun removeItem(pos: Int) {
        aktivitas.removeAt(pos)
        notifyItemRemoved(pos)
    }
}

class AktViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item, parent, false)) {

    private var mTitleView: TextView? = null
    private var mCounterView: TextView? = null


    init {
        mTitleView = itemView.findViewById(R.id.list_title)
        mCounterView = itemView.findViewById(R.id.list_counter)
    }

    fun bind(aktivitas: Aktivitas) {
        mTitleView?. text = aktivitas.title
        mCounterView?.text = aktivitas.counter.toString()
    }

}