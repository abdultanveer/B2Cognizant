package com.example.b2cognizant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.b2cognizant.model.Aquarium

//fragment activity contains the implementaion -- appliance - mybrother

class FragmentActivity : AppCompatActivity(),FragmentHeadlines.OnHeadlineClickListener{

    lateinit var aquarium:Aquarium
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        aquarium = Aquarium(application,lifecycle)
    }

    override fun onHeadlineClicked(headline: String?, position: Int) { //brother is releasing the payment
        Toast.makeText(this,"frag activity--"+headline,Toast.LENGTH_SHORT).show()
        //check if fragment details is not null then the app is running on a tablet else vice versa
       var detailsFragment: FragmentDetails =  supportFragmentManager.findFragmentById(R.id.detailsfrag) as FragmentDetails //as = type casting
        detailsFragment.updateTextview(headline)

    }
}
