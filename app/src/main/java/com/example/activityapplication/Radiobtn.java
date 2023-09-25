package com.example.activityapplication;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.RadioButton;
        import android.widget.RadioGroup;
        import android.widget.Spinner;
        import android.widget.Toast;

        import java.util.ArrayList;

public class Radiobtn extends AppCompatActivity {

    RadioButton rdoBtn;
    RadioGroup radioGroup;
    Button btnSubmit;
    Spinner spn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radiobtn);

        radioGroup = findViewById(R.id.radioGroup);
        btnSubmit  = findViewById(R.id.submitBtn);


        spn = findViewById(R.id.spinner);

        ArrayList<String> stars = new ArrayList<String>();
        stars.add("★☆☆☆☆");
        stars.add("★★☆☆☆");
        stars.add("★★★☆☆");
        stars.add("★★★★☆");
        stars.add("★★★★★");

        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,stars);
        spn.setAdapter(myAdapter);

        spn.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedItem = stars.get(i);
                showToast(selectedItem);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selected = radioGroup.getCheckedRadioButtonId();
                rdoBtn = findViewById(selected);
                assert rdoBtn != null;
                String result = "You picked : " + rdoBtn.getText().toString();
                Toast.makeText(Radiobtn.this,result,Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}