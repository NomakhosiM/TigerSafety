package com.example.tigersafety;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Screen_2 extends AppCompatActivity {

    private TextView textView2;
    private TextView question_1;
    private TextView question_2;
    private Spinner spinner1;
    private Spinner spinner2;
    private Button proceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        textView2 = findViewById(R.id.textView2);
        question_1 = findViewById(R.id.question_1);
        question_2 = findViewById(R.id.question_2);
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        proceed = findViewById(R.id.button3);

        // detailing the first drop down menu
        String[] typeSRO = new String[] {"Unsafe Condition","Unsafe Behaviour","Environmental Observation","Near Miss","Injury"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, typeSRO);
        spinner1.setAdapter(adapter);

        // detailing the second drop down menu
        String[] departments = new String[] {"Quality","Maintenance","Safety","Admin","Contractor","Production","Processing","Packaging","Raw Stores","Warehouse"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, departments);
        spinner2.setAdapter(adapter2);

//        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            public void onItemSelected(AdapterView<?> adapter, View view, int pos, long id) {
//                String selected = adapter.getItemAtPosition(pos).toString();
//                if(selected.isEmpty()){
//                    runOnUiThread(() -> Toast.makeText(Screen_2.this, "Invalid selection", Toast.LENGTH_SHORT).show());
//                }
//            }
//
//            public void onNothingSelected(AdapterView<?> parent) {
//                // Another interface callback
//            }
//        });
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //this button should display different info on recycler view depending on thone dropdown menus.
                Intent intent3 = new Intent(Screen_2.this, Screen_3.class);
                startActivity(intent3);

            }
        });



    }
}