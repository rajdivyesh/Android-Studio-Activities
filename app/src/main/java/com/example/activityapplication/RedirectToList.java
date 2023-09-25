package com.example.activityapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;

public class RedirectToList extends AppCompatActivity {

    private EditText nameEditText;
    private EditText emailEditText;
    private EditText ageEditText;
    private CheckBox checkBoxCourse0;
    private CheckBox checkBoxCourse1;
    private CheckBox checkBoxCourse2;
    private CheckBox checkBoxCourse3;
    private RadioGroup radioGroup;
    private RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redirect_to_list);

        nameEditText = findViewById(R.id.editText1);
        emailEditText = findViewById(R.id.editText2);
        ageEditText = findViewById(R.id.editText3);
        checkBoxCourse0 = findViewById(R.id.checkBoxCourse0);
        checkBoxCourse1 = findViewById(R.id.checkBoxCourse1);
        checkBoxCourse2 = findViewById(R.id.checkBoxCourse2);
        checkBoxCourse3 = findViewById(R.id.checkBoxCourse3);
        radioGroup = findViewById(R.id.radioGroup);
        ratingBar = findViewById(R.id.ratingBar);

        Button nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the user's input data
                String name = nameEditText.getText().toString();
                String email = emailEditText.getText().toString();
                int age = Integer.parseInt(ageEditText.getText().toString());
                boolean course0 = checkBoxCourse0.isChecked();
                boolean course1 = checkBoxCourse1.isChecked();
                boolean course2 = checkBoxCourse2.isChecked();
                boolean course3 = checkBoxCourse3.isChecked();
                int sexId = radioGroup.getCheckedRadioButtonId();
                float rating = ratingBar.getRating();

                // Create an intent to start the second activity
                Intent intent = new Intent(RedirectToList.this, RedirectedListView.class);

                // Pass the input data to the second activity
                intent.putExtra("name", name);
                intent.putExtra("email", email);
                intent.putExtra("age", age);
                intent.putExtra("course0", course0);
                intent.putExtra("course1", course1);
                intent.putExtra("course2", course2);
                intent.putExtra("course3", course3);
                intent.putExtra("sexId", sexId);
                intent.putExtra("rating", rating);

                // Start the second activity
                startActivity(intent);
            }
        });
    }
}