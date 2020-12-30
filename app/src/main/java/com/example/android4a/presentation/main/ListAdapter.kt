package com.example.android4a.presentation.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android4a.R
import com.example.android4a.data.repository.Pokemon

class ListAdapter(
    myDataset: MutableList<Pokemon>,
    listener: OnItemClickListener
) :
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {
    private val values: MutableList<Pokemon>
    private val listener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(item: Pokemon?)
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    inner class ViewHolder(var layout: View) : RecyclerView.ViewHolder(layout) {
        // each data item is just a string in this case
        var txtHeader: TextView
        var txtFooter: TextView

        init {
            txtHeader = layout.findViewById<View>(R.id.firstLine) as TextView
            txtFooter = layout.findViewById<View>(R.id.secondLine) as TextView
        }
    }

    fun add(position: Int, item: Pokemon) {
        values.add(position, item)
        notifyItemInserted(position)
    }

    fun remove(position: Int) {
        values.removeAt(position)
        notifyItemRemoved(position)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        // create a new view
        val inflater = LayoutInflater.from(parent.context)
        val v: View = inflater.inflate(R.layout.row_layout, parent, false)
        // set the view's size, margins, paddings and layout parameters
        return ViewHolder(v)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        val currentPokemon: Pokemon = values[position]
        holder.txtHeader.setText(currentPokemon.name)
        holder.txtHeader.setOnClickListener { remove(position) }
        holder.txtFooter.setText(currentPokemon.url)
        holder.itemView.setOnClickListener { listener.onItemClick(currentPokemon) }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        return values.size
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    init {
        values = myDataset
        this.listener = listener
    }
}