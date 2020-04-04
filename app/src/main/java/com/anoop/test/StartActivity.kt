package com.anoop.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        button.setOnClickListener {
            startActivity(Intent(this,Main2Activity::class.java))
        }

        button2.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}
