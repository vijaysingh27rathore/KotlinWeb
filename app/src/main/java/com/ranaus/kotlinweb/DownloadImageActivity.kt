package com.ranaus.kotlinweb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_download_image.*

class DownloadImageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_download_image)

        submit.setOnClickListener {
            val imageUrl = "http://ranaus.com/test/images/faisalabad.jpg"
            Picasso.get().load(imageUrl).into(img_view)
        }
    }
}
