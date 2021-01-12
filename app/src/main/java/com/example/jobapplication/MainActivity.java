package com.example.jobapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.jobapplication.data.UserDetails;

public class MainActivity extends AppCompatActivity {

    Button mainButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainButton = findViewById(R.id.btn_main);
    }

    public void btn_main_continue(View view){
        startActivity(new Intent(this, LoginActivity.class));
    }

}