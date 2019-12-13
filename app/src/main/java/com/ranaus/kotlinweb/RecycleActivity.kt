package com.ranaus.kotlinweb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycle.*

class RecycleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle)

        var myProductList = ArrayList<EProducts>()

        myProductList.add(EProducts(0,"IPhone",2000,R.drawable.iphone))
        myProductList.add(EProducts(1,"Mac book",3000,R.drawable.macpro))
        myProductList.add(EProducts(2,"I Mac",4000,R.drawable.imac))
        myProductList.add(EProducts(3,"I Pod",5000,R.drawable.ipad))
        myProductList.add(EProducts(4,"Touch",6000,R.drawable.ipodtouch))

        var rvAdapter = RVAdapter(this,myProductList)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter= rvAdapter
    }
}
