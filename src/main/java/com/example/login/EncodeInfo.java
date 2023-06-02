package com.example.login;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;

import com.example.login.InfoView;
import com.google.android.material.button.MaterialButton;

public class EncodeInfo extends AppCompatActivity {

    private EditText lastNameEditText, firstNameEditText, courseEditText, yearEditText, emailAddressEditText,
            contactNumberEditText, birthYearEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encode_info);
        setTitle("Student Information");

        lastNameEditText = findViewById(R.id.lastNameEditText);
        firstNameEditText = findViewById(R.id.firstNameEditText);
        courseEditText = findViewById(R.id.courseEditText);
        yearEditText = findViewById(R.id.yearEditText);
        emailAddressEditText = findViewById(R.id.emailAddressEditText);
        contactNumberEditText = findViewById(R.id.contactNumberEditText);
        birthYearEditText = findViewById(R.id.birthYearEditText);

        MaterialButton submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(view -> {
            String lastName = lastNameEditText.getText().toString();
            String firstName = firstNameEditText.getText().toString();
            String course = courseEditText.getText().toString();
            String year = yearEditText.getText().toString();
            String emailAddress = emailAddressEditText.getText().toString();
            String contactNumber = contactNumberEditText.getText().toString();
            String birthYear = birthYearEditText.getText().toString();

            if (TextUtils.isEmpty(lastName) || TextUtils.isEmpty(firstName) || TextUtils.isEmpty(course) ||
                    TextUtils.isEmpty(year) || TextUtils.isEmpty(emailAddress) ||
                    TextUtils.isEmpty(contactNumber) || TextUtils.isEmpty(birthYear)) {
                Toast.makeText(getApplicationContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            if (TextUtils.isEmpty(year) || !TextUtils.isDigitsOnly(year) ||
                    TextUtils.isEmpty(contactNumber) || !TextUtils.isDigitsOnly(contactNumber) ||
                    TextUtils.isEmpty(birthYear) || !TextUtils.isDigitsOnly(birthYear)) {
                Toast.makeText(getApplicationContext(), "Year, Contact Number, and Birth Year should only contain non-empty digits", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()) {
                Toast.makeText(getApplicationContext(), "Invalid email address", Toast.LENGTH_SHORT).show();
                return;
            }

            String encodedInfo = encodeStudentInfo(lastName, firstName, course, year, emailAddress, contactNumber, birthYear);
            if (encodedInfo != null) {
                Intent intent = new Intent(EncodeInfo.this, InfoView.class);
                intent.putExtra("encodedInfo", encodedInfo);
                intent.putExtra("lastName", lastName);
                intent.putExtra("firstName", firstName);
                intent.putExtra("course", course);
                intent.putExtra("year", Integer.parseInt(year));
                intent.putExtra("emailAddress", emailAddress);
                intent.putExtra("contactNumber", contactNumber);
                intent.putExtra("birthYear", Integer.parseInt(birthYear));
                startActivity(intent);
            }
        });
    }

    private String encodeStudentInfo(String lastName, String firstName, String course, String year,
                                     String emailAddress, String contactNumber, String birthYear) {
        String studentInfo = lastName + firstName + course + year + emailAddress + contactNumber + birthYear;
        return Base64.encodeToString(studentInfo.getBytes(), Base64.DEFAULT);
    }
}

