package com.ranaus.kotlinweb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_show_json.*

class ShowJsonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_json)

        btn_submit.setOnClickListener {
            var productUrl = "http://www.ranaus.com/test/demo_json.php?id="+pro_input.text.toString();
            val requestQueue: RequestQueue = Volley.newRequestQueue(this@ShowJsonActivity)

            val jsonObjectRequest = JsonObjectRequest(Request.Method.GET,productUrl,null,Response.Listener {response ->
                product_name.text = response.getString("name")
                price.text = response.getString("price").toString()
            },Response.ErrorListener { error ->

                product_name.text = error.message
            })

            requestQueue.add(jsonObjectRequest)
        }
    }
}
