package com.example.myhelper

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(listArray:ArrayList<ListItem>, context: Context): RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    var listArrayR = listArray
    var contextR = context

    class ViewHolder(view:View):RecyclerView.ViewHolder(view) {

        val image_id = view.findViewById<ImageView>(R.id.img_item)
        val quantity = view.findViewById<TextView>(R.id.quantity)
        val name_item = view.findViewById<TextView>(R.id.name_item)
        val sell = view.findViewById<TextView>(R.id.sell)
        val grow_up = view.findViewById<TextView>(R.id.grow_up)
        val buy = view.findViewById<TextView>(R.id.buy)

        fun bind(listItem: ListItem, context: Context){
            quantity.text = listItem.quantity
            name_item.text = listItem.name_item
            sell.text = listItem.sell
            grow_up.text = listItem.grow_up
            buy.text = listItem.buy
            image_id.setImageResource(listItem.image_id)
            itemView.setOnClickListener(){
                Toast.makeText(context, "Pressed : ${name_item.text}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(contextR)
        return ViewHolder(inflater.inflate(R.layout.item_inventory_content, parent, false))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var listItem = listArrayR.get(position)
        holder.bind(listItem, contextR)
    }

    override fun getItemCount(): Int {
        return listArrayR.size
    }
}