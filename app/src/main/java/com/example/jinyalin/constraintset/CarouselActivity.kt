package com.example.jinyalin.constraintset

import android.os.Build
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.constraint.ConstraintSet
import android.support.v7.app.AppCompatActivity
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.View
import android.view.animation.OvershootInterpolator
import kotlinx.android.synthetic.main.activity_carousel.*

/**
 * Yalin on 2018/11/30
 */
class CarouselActivity : AppCompatActivity() {
    private var selectedView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carousel)

        setupAnimations()
    }

    private fun setupAnimations() {
        selectedView = null

        root.setOnClickListener {
            toDefault()
        }

        javaImg.setOnClickListener {
            if (selectedView != javaImg) {
                updateConstraints(R.layout.activity_carousel_java)
                selectedView = javaImg
            } else {
                toDefault()
            }
        }

        kotlinImg.setOnClickListener {
            if (selectedView != kotlinImg) {
                updateConstraints(R.layout.activity_carousel_kotlin)
                selectedView = kotlinImg
            } else {
                toDefault()
            }
        }
    }

    private fun toDefault() {
        if (selectedView != null) {
            updateConstraints(R.layout.activity_carousel)
            selectedView = null
        }
    }

    private fun updateConstraints(@LayoutRes id: Int) {
        if (Build.VERSION.SDK_INT >= 19) {
            val newConstraint = ConstraintSet()
            newConstraint.clone(this, id)
            newConstraint.applyTo(root)
            val transition = ChangeBounds()
            transition.interpolator = OvershootInterpolator()

            TransitionManager.beginDelayedTransition(root, transition)
        }
    }
}