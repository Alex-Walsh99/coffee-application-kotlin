package com.example.wmadcoffeeapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CoffeeAdaptor (private val context: CoffeeMenuActivity, private val coffees: ArrayList<Coffee>)
    : RecyclerView.Adapter<CoffeeAdaptor.CoffeeViewHolder>(){

        class CoffeeViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
            val txtTitle: TextView = view.findViewById(R.id.txtTitle)
            val imgCoffee: ImageView = view.findViewById(R.id.imgCoffee)
            val txtDescription: TextView = view.findViewById(R.id.txtDescription)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoffeeViewHolder {
        val adaptorLayout = LayoutInflater.from(parent.context).inflate(R.layout.coffee_layout, parent, false)
        return CoffeeViewHolder(adaptorLayout)
    }

    override fun onBindViewHolder(holder: CoffeeViewHolder, position: Int) {
        val theCoffee = coffees.get(position)
        holder.txtTitle.text = theCoffee.title
        holder.txtDescription.text = theCoffee.description
        val resourceId = context.resources.getIdentifier("@drawable/" + theCoffee.image,"drawable", context.packageName)
        holder.imgCoffee.setImageResource(resourceId)
    }

    override fun getItemCount() = coffees.size

}