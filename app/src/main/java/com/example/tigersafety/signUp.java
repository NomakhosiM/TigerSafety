package com.example.tigersafety;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signUp extends AppCompatActivity {

    private EditText emailSignup;
    private EditText pwSignup;
    private EditText pwcSignup;
    private Button gotoprofile;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();

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
                    mAuth.createUserWithEmailAndPassword(EmailSignUp,PWSignup)
                            .addOnCompleteListener(signUp.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()){
                                        Intent intent = new Intent(signUp.this, setProfile.class);
                                        startActivity(intent);
                                    }else{
                                        Log.w("user exeception", "Create user unsuccessful", task.getException());
                                        Toast.makeText(signUp.this,"please try again", Toast.LENGTH_SHORT).show();
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
        if (currentUser != null){
            currentUser.reload();
        }
    }
}


