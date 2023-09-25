package com.example.activityapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ListViewTogglebtn extends AppCompatActivity {

    String[] teacher = {"Pargol", "Danial", "Michelle"};
    ListView listview;
    ToggleButton tgbtn;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_togglebtn);

        btn = findViewById(R.id.btnDone);
        listview = findViewById(R.id.myList);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.teacher_toggle_layout, R.id.txtteacher, teacher);
        listview.setAdapter(adapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder selectedNames = new StringBuilder();

                for (int i = 0; i < listview.getCount(); i++) {
                    View listItem = listview.getChildAt(i);
                    ToggleButton toggleButton = listItem.findViewById(R.id.tgbtn);
                    if (toggleButton.isChecked()) {
                        selectedNames.append(teacher[i]).append(", ");
                    }
                }

                if (selectedNames.length() > 0) {
                    selectedNames.delete(selectedNames.length() - 2, selectedNames.length()); // Remove the trailing ", "
                    Toast.makeText(ListViewTogglebtn.this, "Selected names: " + selectedNames.toString(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ListViewTogglebtn.this, "No names selected.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}