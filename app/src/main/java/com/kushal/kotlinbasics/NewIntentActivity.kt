package com.kushal.kotlinbasics

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class NewIntentActivity : AppCompatActivity() {

    lateinit var mContext: Context
    lateinit var data_tv : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_intent)

        mContext = this;
        init()
    }

    private fun init() {

        data_tv = findViewById(R.id.tv_data)

        val name = intent.getStringExtra(MainActivity.KEY__VALUE)

        data_tv.text = "Hey $name"

    }
}