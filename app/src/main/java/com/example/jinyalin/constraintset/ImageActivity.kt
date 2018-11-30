package com.example.jinyalin.constraintset

import android.os.Build
import android.os.Bundle
import android.support.constraint.ConstraintSet
import android.support.v7.app.AppCompatActivity
import android.transition.TransitionManager
import kotlinx.android.synthetic.main.activity_image.*

/**
 * Yalin on 2018/11/30
 */
class ImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
        applyTransitionOptions()
    }

    private fun applyTransitionOptions() {
        var set = false
        val constraint1 = ConstraintSet()
        constraint1.clone(root)

        val constraint2 = ConstraintSet()
        constraint2.clone(this, R.layout.activity_image_alt)

        imageView.setOnClickListener {
            if (Build.VERSION.SDK_INT >= 19) {
                TransitionManager.beginDelayedTransition(root)

                val constraint = if (set) constraint1 else constraint2
                constraint.applyTo(root)

                set = !set
            }
        }
    }
}