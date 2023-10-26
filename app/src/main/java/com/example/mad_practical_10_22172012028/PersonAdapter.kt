package com.example.mad_practical_10_22172012028

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.TextView
import com.google.android.material.button.MaterialButton
import java.util.ArrayList

class PersonAdapter(context:Context,val array:ArrayList<Person>):ArrayAdapter<Person>(context,0,array) {




    @SuppressLint("MissingInflatedId")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.person_item,parent,false)
        val person_data = array.get(position)
        view.findViewById<TextView>(R.id.textView_name).text=person_data.name
        view.findViewById<TextView>(R.id.textView_no).text=person_data.phoneNo
        view.findViewById<TextView>(R.id.textView_email).text=person_data.emailId
        view.findViewById<TextView>(R.id.textView_address).text=person_data.address
        view.findViewById<MaterialButton>(R.id.btn_autorenew).setOnClickListener {
            Intent(parent.context,MapActivity::class.java).putExtra("Object",person_data).apply { context.startActivity(this) }
        }
        return view
    }

}