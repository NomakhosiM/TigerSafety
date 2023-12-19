package com.example.tigersafety;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

public class setProfile extends AppCompatActivity {

    String[] department = {"Quality","Maintenance","Safety","Admin","Contractor","Production","Processing","Packaging","Raw Stores","Warehouse"};
    String[] letters = {"A","B","C","D"};
    AutoCompleteTextView autoCompleteTextView1;
    AutoCompleteTextView autoCompleteTextView2;
    ArrayAdapter<String> adapterItems1;
    ArrayAdapter<String> adapterItems2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_profile);

        adapterItems2 = new ArrayAdapter<String>(this, R.layout.list_item,letters);
        autoCompleteTextView2 = findViewById(R.id.auto_complete_textview2);
        autoCompleteTextView1 = findViewById(R.id.auto_complete_textview1);
        autoCompleteTextView2.setAdapter(adapterItems2);
        adapterItems1 = new ArrayAdapter<String>(this, R.layout.list_item, department);
        autoCompleteTextView1.setAdapter(adapterItems1);
        autoCompleteTextView2.setVisibility(View.GONE);

        autoCompleteTextView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String item = adapterView.getItemAtPosition(position).toString();
                String[] let = {"Production","Warehouse","Packaging","Raw Stores","Processing"};
                //connect assign department on Firebase

                for (int k=0; k<let.length; k++){
                    if (item.equals(k))
                        autoCompleteTextView2.setVisibility(View.VISIBLE);
                }
            }
        });
        autoCompleteTextView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String letter = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(setProfile.this, "letter "+ letter, Toast.LENGTH_SHORT).show();

            }
        });
    }
}
