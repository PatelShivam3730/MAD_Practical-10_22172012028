package com.example.mad_practical_10_22172012028

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    private lateinit var personlistview:ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var personlistview = findViewById<ListView>(R.id.listview)
    }

    fun setpersondatatolistview()
    {
        personlistview.adapter=PersonAdapter(this, arrayListOf(
            Person("111","Shivam","Shivampatel19@gnu.ac.in","+917046526862","Valsad",150.64949,5645941.1649),
            Person("222","jiya","jiyampatel19@gnu.ac.in","+917046526862","Valsad",150.649459,5645941.1649),
            Person("333","roshan","tadviroshan19@gnu.ac.in","+919864738290","Valsad",150.649449,5645941.1649),
            Person("444","mukesh","mukeshpatel19@gnu.ac.in","+917046526862","Valsad",150.64949,5645941.1649),
            Person("555","anil","anilpatel19@gnu.ac.in","+917069226862","Valsad",150.64949,5645941.1649),
            ))}

}