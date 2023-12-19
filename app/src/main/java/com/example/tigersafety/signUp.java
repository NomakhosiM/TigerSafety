package com.example.tigersafety;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signUp extends AppCompatActivity {

    private EditText emailSignup;
    private EditText pwSignup;
    private EditText pwcSignup;
    private Button gotoprofile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        emailSignup = findViewById(R.id.emailSignup);
        pwSignup = findViewById(R.id.pwSignup);
        pwcSignup = findViewById(R.id.pwcSignup);
        gotoprofile = findViewById(R.id.gotoprofile);

        gotoprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String EmailSignUp = (String) emailSignup.getText().toString().trim();
                String PWSignup = (String) pwSignup.getText().toString().trim();
                String PWCSignup = (String) pwcSignup.getText().toString().trim();

                //validating the email
                if(EmailSignUp.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(EmailSignUp).matches()){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(signUp.this,"Invalid email",Toast.LENGTH_SHORT).show();
                        }
                    });
                }

                //validating the password
                else if (!PWSignup.equals(PWCSignup)){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(signUp.this, "passwords do not match",Toast.LENGTH_SHORT).show();
                        }
                    });
                }

                else {
                    //send password and email to firebase
                    Intent intent = new Intent(signUp.this, setProfile.class);
                    startActivity(intent);
                }

            }
        });
    }
}


