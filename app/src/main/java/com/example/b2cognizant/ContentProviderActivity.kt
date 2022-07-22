package com.example.b2cognizant

import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.b2cognizant.FeedReaderContract.FeedEntry

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

    fun cpHandler(view: View) {
        when(view.id){
            R.id.btnPutCp ->{ putCp()}
            R.id.btnGetCp -> { getCp()}
        }

    }

    private fun getCp() {
        val uriEntries: Uri = Uri.parse("content://com.demo.user.provider/users")
        val cursor: Cursor? = getContentResolver().query(uriEntries, null, null, null, null)
        cursor?.moveToLast()
        val titleIndex = cursor!!.getColumnIndexOrThrow(FeedEntry.COLUMN_NAME_TITLE)
        val subtitleIndex = cursor.getColumnIndexOrThrow(FeedEntry.COLUMN_NAME_SUBTITLE)
        val title = cursor.getString(titleIndex)
        val subtitle = cursor.getString(subtitleIndex)
        Log.i(TAG,title +"---"+subtitle)
    }

    private fun putCp() {
        val uriEntries: Uri = Uri.parse("content://com.demo.user.provider/users")
        // val cursor: Cursor? = getContentResolver().query(uriEntries, null, null, null, null)
        val mapValues = ContentValues()
        mapValues.put(FeedEntry.COLUMN_NAME_TITLE, "title_cp")
        mapValues.put(FeedEntry.COLUMN_NAME_SUBTITLE, "subtitle_cp")
        contentResolver.insert(uriEntries, mapValues)
    }

    companion object{
        var TAG = ContentProviderActivity::class.java.simpleName
    }
}