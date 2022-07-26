package com.example.b2cognizant

import com.example.b2cognizant.FeedReaderContract.FeedEntry


import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    lateinit var etTitle:EditText
    lateinit var  etDetails:EditText
    lateinit var dbAccessObject: DbAccessObject
    lateinit var tvDb : TextView
    lateinit var todoLv : ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etTitle = findViewById(R.id.etTitle)
        etDetails = findViewById(R.id.etDetails)
        tvDb = findViewById(R.id.tvDbQuery)
        todoLv = findViewById(R.id.todolist)
        dbAccessObject = DbAccessObject(this)
        dbAccessObject.openDb()
    }


    override fun onStart() {
        super.onStart()
        var from = arrayOf(FeedEntry.COLUMN_NAME_TITLE, FeedEntry.COLUMN_NAME_SUBTITLE)
        var to = intArrayOf(android.R.id.text1,android.R.id.text2)

       var dataCursor:Cursor =  dbAccessObject.getAllRows()
        var adapter: CursorAdapter = SimpleCursorAdapter(this,
            android.R.layout.simple_list_item_2,
            dataCursor,from,to,1 )
        todoLv.adapter = adapter
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
        var todo = Todo(title,details)
        //put the data into db
        dbAccessObject.createRow(title,details)
        dbAccessObject.createRow(todo)
    }
}