package com.example.mad_practical_10_22172012040

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.mad_practical_10_22172012028.Person
import com.example.mad_practical_10_22172012028.R
import java.util.ArrayList

class PersonAdapter(context:Context,val array:ArrayList<Person>):ArrayAdapter<Person>(context,0,array) {


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.person_item,parent,false)
        val person_data = array.get(position)
        view.findViewById<TextView>(R.id.textView_name).text=person_data.name
        view.findViewById<TextView>(R.id.textView_no).text=person_data.phonenumber
        view.findViewById<TextView>(R.id.textView_email).text=person_data.emailid
        view.findViewById<TextView>(R.id.textView_address).text=person_data.address
        return view
    }

}