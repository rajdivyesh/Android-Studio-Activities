package com.example.activityapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class RedirectedListView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redirected_list_view);

        // Get the ListView from the layout
        ListView detailsListView = findViewById(R.id.detailsListView);

        // Get the data passed from the first activity
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String email = intent.getStringExtra("email");
        int age = intent.getIntExtra("age", 0);
        boolean course0 = intent.getBooleanExtra("course0", false);
        boolean course1 = intent.getBooleanExtra("course1", false);
        boolean course2 = intent.getBooleanExtra("course2", false);
        boolean course3 = intent.getBooleanExtra("course3", false);
        int sexId = intent.getIntExtra("sexId", R.id.radioButtonMale);
        float rating = intent.getFloatExtra("rating", 0.0f);

        // Create an array of strings to display the details
        String[] details = {
                "Name: " + name,
                "Email: " + email,
                "Age: " + age,
                "Courses: " + (course0 ? "Android Development , " : "") + (course1 ? "Web Services Development, " : "") + (course2 ? "Database Management, " : "") + (course3 ? "Java Programming" : ""),
                "Sex: " + (sexId == R.id.radioButtonMale ? "Male" : (sexId == R.id.radioButtonFemale ? "Female" : "Other")),
                "Rating: " + rating
        };

        // Create an ArrayAdapter to populate the ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, details);

        // Set the adapter for the ListView
        detailsListView.setAdapter(adapter);
    }
}