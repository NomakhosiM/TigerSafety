package com.example.tigersafety;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class logIn extends AppCompatActivity {

    private EditText emailLogIn;
    private EditText pwLogIn;
    private Button button;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        mAuth = FirebaseAuth.getInstance();
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
                    //I need to connect to
                    mAuth.signInWithEmailAndPassword(EmailLogIn, PWLogIn)
                            .addOnCompleteListener(logIn.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()){
                                        Intent intent = new Intent(logIn.this, Screen_1.class);
                                        startActivity(intent);
                                    } else {
                                        Log.w("login failed", "Authentication failed", task.getException());
                                        Toast.makeText(logIn.this, "check email and password", Toast.LENGTH_LONG).show();
                                    }
                                }
                            });

                }
            }

        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null)
            currentUser.reload();
    }
}