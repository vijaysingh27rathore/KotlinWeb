package com.ranaus.kotlinweb

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RVAdapter(var context: Context, var arrayList: ArrayList<EProducts>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        var productView = LayoutInflater.from(context).inflate(R.layout.rv_row,parent,false)

        return productViewHolder(productView)
    }

    override fun getItemCount(): Int {

        return arrayList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as productViewHolder).initializeUIComponents(arrayList[position].id, arrayList[position].name,
            arrayList[position].price,arrayList[position].picture)
    }

    inner class productViewHolder(myView:View): RecyclerView.ViewHolder(myView)
    {
        var productId = myView.findViewById<TextView>(R.id.rv_id)
        var productName = myView.findViewById<TextView>(R.id.rv_name)
        var productPrice = myView.findViewById<TextView>(R.id.rv_price)
        var productImage = myView.findViewById<ImageView>(R.id.rv_img_view)

        fun initializeUIComponents(pId:Int,pName:String,pPrice:Int, pPic:Int)
        {
            productId.text = pId.toString()
            productName.text = pName
            productPrice.text = pPrice.toString()
            productImage.setImageResource(pPic)
        }
    }
}