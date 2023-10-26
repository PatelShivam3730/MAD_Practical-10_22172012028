package com.example.mad_practical_10_22172012028
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.mad_practical_10_22172012028.PersonAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private lateinit var personListView : ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        personListView = findViewById(R.id.listview_main)
        val btn_flt = findViewById<FloatingActionButton>(R.id.btn_autorenew)
        btn_flt.setOnClickListener{
            setPersonDataToListView()
//            Intent(MapsActivity@this,MapsActivity::class.java).also {
//                startActivity(it)
//            }
        }
    }

    fun setPersonDataToListView(){
     personListView.adapter=PersonAdapter(this,
        arrayListOf(
            Person("1", "Shivam","shivampatel@gmail.com", "9558297717","Bharuch-392001",21.7051,72.9959),
             Person("2", "Risky","sujalpatel1882@gmail.com", "9558297717","Bharuch-392001",21.7051,72.9959),
             Person("3", "jiys","sujalpatel1882@gmail.com", "9558297717","Bharuch-392001",21.7051,72.9959),
             Person("4", "Ashish","sujalpatel1882@gmail.com", "9558297717","Bharuch-392001",21.7051,72.9959),
            Person("5", "nilima","sujalpatel1882@gmail.com", "9558297717","Bharuch-392001",21.7051,72.9959),
             Person("6", "anil","sujalpatel1882@gmail.com", "9558297717","Bharuch-392001",21.7051,72.9959),
             Person("7", "mukesh","sujalpatel1882@gmail.com", "9558297717","Bharuch-392001",21.7051,72.9959),
           Person("8", "shreni","sujalpatel1882@gmail.com", "9558297717","Bharuch-392001",21.7051,72.9959),
             Person("9", "hello","sujalpatel1882@gmail.com", "9558297717","Bharuch-392001",21.7051,72.9959),
             Person("10", "Jadu_female","sujalpatel1882@gmail.com", "9558297717","Bharuch-392001",21.7051,72.9959),
             ))

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val data = HttpRequest().makeServiceCall(
                    "https://api.json-generator.com/templates/qjeKFdjkXCdK/data",
                    "rbn0rerl1k0d3mcwgw7dva2xuwk780z1hxvyvrb1")
                withContext(Dispatchers.Main) {
                    try {
                        if(data != null)
                            runOnUiThread{getPersonDetailsFromJson(data)}
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun getPersonDetailsFromJson(sJson: String?) {
        val personList = ArrayList<Person>()
        try {
            val jsonArray = JSONArray(sJson)
            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray[i] as JSONObject
                val person = Person(jsonObject)
                personList.add(person)
            }
            var listView1 : ListView = findViewById(R.id.listview_main)
            listView1.adapter = PersonAdapter(this, personList)
        } catch (ee: JSONException) {
            ee.printStackTrace()
        }
    }
}