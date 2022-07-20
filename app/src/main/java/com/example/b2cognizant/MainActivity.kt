package com.example.b2cognizant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var etTitle:EditText
    lateinit var  etDetails:EditText
    lateinit var dbAccessObject: DbAccessObject
    lateinit var tvDb : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etTitle = findViewById(R.id.etTitle)
        etDetails = findViewById(R.id.etDetails)
        tvDb = findViewById(R.id.tvDbQuery)
        dbAccessObject = DbAccessObject(this)
        dbAccessObject.openDb()
    }

    fun dbHandler(view: View) {
        when(view.id){
            R.id.btnCommit -> { commitDb()}
            R.id.btnQuery -> { queryDb()}
        }
    }

    private fun queryDb() {
       var result: String = dbAccessObject.query()
        tvDb.setText(result)
    }

    private fun commitDb() {
        //get the data from the edittexts
        var title = etTitle.text.toString()
        var details = etDetails.text.toString()
        //put the data into db
        dbAccessObject.createRow(title,details)
    }
}