package com.example.tigersafety;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Screen_4 extends AppCompatActivity {

    private EditText comments;
    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen4);

        comments = findViewById(R.id.comments);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String comment = comments.getText().toString();
                if (comment.isEmpty() || comment.length()<10){
                    runOnUiThread(() -> Toast.makeText(Screen_4.this, "Invalid Comment", Toast.LENGTH_SHORT).show());
                }
                else {
                    runOnUiThread(() -> Toast.makeText(Screen_4.this, "Comment submitted successfully", Toast.LENGTH_SHORT).show());

                }
            }
        });

    }
}