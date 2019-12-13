package com.ranaus.kotlinweb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_show_all_json.*

class ShowAllJsonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_all_json)

        all.setOnClickListener {
            var allProductsURL = "http://www.ranaus.com/test/array_json1.php"
            var allProducts:String = ""
            val requestQueue:RequestQueue = Volley.newRequestQueue(this@ShowAllJsonActivity)
            val jsonArrayRequest:JsonArrayRequest = JsonArrayRequest(Request.Method.GET,allProductsURL,null,Response.Listener { response ->

                for (productIndex in 0.until(response.length()))
                {
                    /*allProducts += response.getJSONObject(productIndex).getString("name")+" - "+
                            response.getJSONObject(productIndex).getString("price")*/

                    var proName = response.getJSONObject(productIndex).getString("name")
                    var proPrice = response.getJSONObject(productIndex).getInt("price")
                    allProducts += proName +" - "+ proPrice +"\n"
                }

                text_view.text = allProducts
            },Response.ErrorListener { error ->
                text_view.text = error.message
            })

            requestQueue.add(jsonArrayRequest)
        }
    }
}
