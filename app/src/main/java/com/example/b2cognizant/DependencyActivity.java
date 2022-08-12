package com.example.b2cognizant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;

import com.example.b2cognizant.di.DaggerMyComponent;
import com.example.b2cognizant.di.MyComponent;
import com.example.b2cognizant.di.SharedPrefModule;

import javax.inject.Inject;

public class DependencyActivity extends AppCompatActivity implements View.OnClickListener {
    EditText inUsername, inNumber;
    Button btnSave, btnGet;
    private MyComponent myComponent;

    @Inject
    SharedPreferences sharedPreferencesByModule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependency);

        //SharedPreferences myPreferences = getSharedPreferences("filename",MODE_PRIVATE);
        myComponent = DaggerMyComponent.builder()
                .sharedPrefModule(new SharedPrefModule(this))
                .build();
        myComponent.inject(this);
        initViews();
    }

    private void initViews() {
        btnGet = findViewById(R.id.btnGet);
        btnSave = findViewById(R.id.btnSave);
        inUsername = findViewById(R.id.inUsername);
        inNumber = findViewById(R.id.inNumber);
        btnSave.setOnClickListener(this);
        btnGet.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btnGet:
                Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
                findViewById(R.id.inUsername).startAnimation(shake);
                //inUsername.setText(sharedPreferencesByModule.getString("username", "default"));
                //inNumber.setText(sharedPreferencesByModule.getString("number", "12345"));
                break;
            case R.id.btnSave:
                SharedPreferences.Editor editor = sharedPreferencesByModule.edit();
                editor.putString("username", inUsername.getText().toString().trim());
                editor.putString("number", inNumber.getText().toString().trim());
                editor.apply();
                break;

        }
    }
}