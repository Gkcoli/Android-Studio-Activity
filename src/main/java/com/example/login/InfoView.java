package com.example.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class InfoView extends AppCompatActivity {

    private TextView lastNameTextView;
    private TextView firstNameTextView;
    private TextView courseTextView;
    private TextView yearTextView;
    private TextView emailAddressTextView;
    private TextView contactNumberTextView;
    private TextView birthYearTextView;
    private TextView ageTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_view);
        setTitle("Information View");

        // Get references to the TextViews and Button
        lastNameTextView = findViewById(R.id.lastNameTextView);
        firstNameTextView = findViewById(R.id.firstNameTextView);
        courseTextView = findViewById(R.id.courseTextView);
        yearTextView = findViewById(R.id.yearTextView);
        emailAddressTextView = findViewById(R.id.emailAddressTextView);
        contactNumberTextView = findViewById(R.id.contactNumberTextView);
        birthYearTextView = findViewById(R.id.birthYearTextView);
        ageTextView = findViewById(R.id.ageTextView);


        // Retrieve the student information from intent extras
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String lastName = extras.getString("lastName");
            String firstName = extras.getString("firstName");
            String course = extras.getString("course");
            int year = extras.getInt("year");
            String emailAddress = extras.getString("emailAddress");
            String contactNumber = extras.getString("contactNumber");
            int birthYear = extras.getInt("birthYear");

            // Set the student information in the TextViews
            lastNameTextView.setText("Last Name: " + lastName);
            firstNameTextView.setText("First Name: " + firstName);
            courseTextView.setText("Course: " + course);
            yearTextView.setText("Year: " + year);
            emailAddressTextView.setText("Email Address: " + emailAddress);
            contactNumberTextView.setText("Contact Number: " + contactNumber);
            birthYearTextView.setText("Birth Year: " + birthYear);

            // Compute and display the age
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            int age = currentYear - birthYear;
            ageTextView.setText("Age: " + age);
        }

        // Set a click listener for the back button

    }
}
