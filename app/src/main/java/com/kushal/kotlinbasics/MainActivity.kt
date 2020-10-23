package com.kushal.kotlinbasics

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val KEY__VALUE = "name"
    }

    lateinit var mContext : Context
    lateinit var myEditText : EditText
    lateinit var click_me : Button
    lateinit var listView : ListView
    lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mContext = this
        init()

    }

    private fun init() {

        myEditText = findViewById(R.id.edt_txt)
        click_me = findViewById(R.id.click_me)
        listView = findViewById(R.id.listView)

        val my_array : ArrayList<String> = ArrayList<String>()

        my_array.add("SpiderMan")
        my_array.add("SuperMan")
        my_array.add("BatMan")

        adapter = ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, my_array)
        listView.adapter = adapter

        click_me.setOnClickListener{

            val s: String = myEditText.text.toString()

            if (s.equals("")) {
                myEditText.setError("Please Enter Name")
            } else {
                my_array.add(s)
                adapter.notifyDataSetChanged()
            }

        }

        listView.setOnItemClickListener { parent, view, position, id ->

            Toast.makeText(mContext, "You Clicked On " + my_array.get(position), Toast.LENGTH_SHORT).show()

        }

    }

}