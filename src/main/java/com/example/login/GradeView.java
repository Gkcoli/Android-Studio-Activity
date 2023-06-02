package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.widget.TextView;

public class GradeView extends AppCompatActivity {

    private TextView lastNameTextView;
    private TextView firstNameTextView;
    private TextView attendanceTextView;
    private TextView quiz1TextView;
    private TextView quiz2TextView;
    private TextView quiz3TextView;
    private TextView quiz4TextView;
    private TextView examTextView;
    private TextView averageTextView;
    private TextView statusTextView;
    private TextView remarksTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade_view);
        setTitle("Grade View");

        lastNameTextView = findViewById(R.id.lastNameTextView);
        firstNameTextView = findViewById(R.id.firstNameTextView);
        attendanceTextView = findViewById(R.id.attendanceTextView);
        quiz1TextView = findViewById(R.id.quiz1TextView);
        quiz2TextView = findViewById(R.id.quiz2TextView);
        quiz3TextView = findViewById(R.id.quiz3TextView);
        quiz4TextView = findViewById(R.id.quiz4TextView);
        examTextView = findViewById(R.id.examTextView);
        averageTextView = findViewById(R.id.averageTextView);
        statusTextView = findViewById(R.id.statusTextView);
        remarksTextView = findViewById(R.id.remarksTextView);

        // Retrieve data from Intent extras
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String lastName = extras.getString("lastName");
            String firstName = extras.getString("firstName");
            int attendance = extras.getInt("attendance");
            int quiz1 = extras.getInt("quiz1");
            int quiz2 = extras.getInt("quiz2");
            int quiz3 = extras.getInt("quiz3");
            int quiz4 = extras.getInt("quiz4");
            int exam = extras.getInt("exam");
            double average = extras.getDouble("average");
            String status = extras.getString("status");
            String remarks = extras.getString("remarks");

            // Display data in TextViews
            lastNameTextView.setText(lastName);
            firstNameTextView.setText(firstName);
            attendanceTextView.setText(String.valueOf(attendance));
            quiz1TextView.setText(String.valueOf(quiz1));
            quiz2TextView.setText(String.valueOf(quiz2));
            quiz3TextView.setText(String.valueOf(quiz3));
            quiz4TextView.setText(String.valueOf(quiz4));
            examTextView.setText(String.valueOf(exam));
            averageTextView.setText(String.format("%.2f", average));
            statusTextView.setText(status);
            remarksTextView.setText(remarks);
        }
    }
}