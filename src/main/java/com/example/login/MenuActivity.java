package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setTitle("Menu Activity");

        MaterialButton logoutbtn = (MaterialButton) findViewById(R.id.logoutbtn);


        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform logout logic here
                Toast.makeText(getApplicationContext(), "Logout Successful", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MenuActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Clear all previous activities
                startActivity(intent);
                finish(); // Finish the current activity
            }
        });


    }

    public void encodebtn(View v) {
        Intent i = new Intent(this, EncodeInfo.class);
        startActivity(i);
    }
    public void gradebtn(View v){
        Intent intent = new Intent(this, EncodeGrade.class);
        startActivity(intent);
    }
}
