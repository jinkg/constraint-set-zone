package com.example.jinyalin.constraintset

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun imageTransition(view: View) {
        startActivity(Intent(this, ImageActivity::class.java))
    }

    fun carouselActivity(view: View) {
        startActivity(Intent(this, CarouselActivity::class.java))
    }

    fun shoppingActivity(view: View) {
        startActivity(Intent(this, ShoppingActivity::class.java))
    }
}
