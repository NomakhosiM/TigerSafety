package com.example.tigersafety;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Screen_1 extends AppCompatActivity {

    private Button reportSRO;
    private Button reportPB;
    private TextView textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen1);

        reportSRO = findViewById(R.id.reportSRO);
        reportPB = findViewById(R.id.positiveBehaviour);
        textView1 = findViewById(R.id.textView1);

        reportSRO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Screen_1.this, Screen_2.class);
                startActivity(intent);
            }
        });

        reportPB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Screen_1.this, Screen_4.class);
                startActivity(intent2);

            }
        });
    }
}

