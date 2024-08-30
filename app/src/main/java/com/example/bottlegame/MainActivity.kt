package com.example.bottlegame

import android.os.Bundle
import android.view.animation.RotateAnimation
import android.widget.ImageView
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    private lateinit var bottle: ImageView
    private val random = java.util.Random()
    private var ultimateDirection: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottle = findViewById(R.id.bottle)

        bottle.setOnClickListener {
            val newDirection = random.nextInt(1800)
            val eixoX = bottle.width / 2f
            val eixoY = bottle.height / 2f

            val spin = RotateAnimation(ultimateDirection.toFloat(), newDirection.toFloat(), eixoX, eixoY)
            spin.duration = 2500
            spin.fillAfter = true

            ultimateDirection = newDirection
            bottle.startAnimation(spin)
        }
    }
}
