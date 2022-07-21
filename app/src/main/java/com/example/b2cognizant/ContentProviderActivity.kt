package com.example.b2cognizant

import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import androidx.appcompat.app.AppCompatActivity

class ContentProviderActivity : AppCompatActivity() {
    lateinit var cpListView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_provider)
        cpListView = findViewById(R.id.cpListview)

        val uriSms: Uri = Uri.parse("content://sms/inbox")
        val cursor: Cursor? = getContentResolver().query(uriSms, null, null, null, null)
        var from = arrayOf("body","address")
        var to = intArrayOf(android.R.id.text1,android.R.id.text2)
         var adapter: SimpleCursorAdapter = SimpleCursorAdapter(this,
         android.R.layout.simple_list_item_2,
             cursor,from,to,0)
        cpListView.adapter = adapter

    }
}