package com.example.listexamples

import android.os.Bundle
import android.widget.GridView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.util.TypedValueCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class GridImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_image)


        // 1. Data
        val thumbs = mutableListOf<Int>()
        repeat(28) {
            thumbs.add(resources.getIdentifier("thumb${it + 1}", "drawable", packageName))
        }

        // 2. Adapter
        val space = TypedValueCompat.dpToPx(8f, resources.displayMetrics)
        val imageSize: Int = ((resources.displayMetrics.widthPixels - space) / 3).toInt()

        val adapter = ImageAdapter(thumbs, imageSize)

        // 3. Set adapter of gridview
        val gridImages = findViewById<GridView>(R.id.grid_view)
        gridImages.adapter = adapter
    }
}