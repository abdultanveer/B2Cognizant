package com.example.b2cognizant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

//fragment activity contains the implementaion -- appliance
class FragmentActivity : AppCompatActivity(),FragmentHeadlines.OnHeadlineClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
    }

    override fun onHeadlineClicked(headline: String?, position: Int) {
        Toast.makeText(this,"frag activity--"+headline,Toast.LENGTH_SHORT).show()
        //check if fragment details is not null then the app is running on a tablet else vice versa
       var detailsFragment: FragmentDetails =  supportFragmentManager.findFragmentById(R.id.detailsfrag) as FragmentDetails //as = type casting
        detailsFragment.updateTextview(headline)

    }
}