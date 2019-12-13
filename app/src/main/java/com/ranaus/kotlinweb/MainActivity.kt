package com.ranaus.kotlinweb

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var sharedP: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*add_product.setOnClickListener {
            sharedP = getSharedPreferences("addData",Context.MODE_PRIVATE)
            var myEditor = sharedP?.edit()
            myEditor?.putString("product_name",name.text.toString())
            myEditor?.commit()

            Toast.makeText(this,"Value inserted ",Toast.LENGTH_LONG).show()
        }

        get_product.setOnClickListener {
            text_view.text = sharedP?.getString("product_name","Product Name")
        }*/

        btn.setOnClickListener {
            var serverUrl:String = "http://www.ranaus.com/test/test1file.php"
            var requestQueue:RequestQueue = Volley.newRequestQueue(this@MainActivity)
            var stringRequest = StringRequest(Request.Method.GET,serverUrl,Response.Listener { response ->

                text_view.text = response
            },Response.ErrorListener {error ->
                text_view.text = error.message
            })

            requestQueue.add(stringRequest)
        }
    }
}
