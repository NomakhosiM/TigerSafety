package com.example.tigersafety;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class logIn extends AppCompatActivity {

    private EditText emailLogIn;
    private EditText pwLogIn;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        emailLogIn = findViewById(R.id.emailLogIn);
        pwLogIn = findViewById(R.id.pwLogIn);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String EmailLogIn = emailLogIn.getText().toString().trim();
                String PWLogIn = pwLogIn.getText().toString().trim();

                //! connect email and password to firebase and validate each
                if (EmailLogIn.isEmpty() || PWLogIn.isEmpty()) {

                    runOnUiThread(() -> Toast.makeText(logIn.this, "Invalid email or Invalid password", Toast.LENGTH_SHORT).show());
                } else {
                    //I need to connect to firebase
                    Intent intent = new Intent(logIn.this, Screen_1.class);
                    startActivity(intent);
                }
            }

        });

    }
}