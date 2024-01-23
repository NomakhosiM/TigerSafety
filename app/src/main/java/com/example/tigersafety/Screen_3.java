package com.example.tigersafety;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

public class Screen_3 extends AppCompatActivity {

    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    private Button button4;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this,gso);
        button4 = findViewById(R.id.button4);
        editText = findViewById(R.id.editTextText);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if(acct!=null){
            String personName = acct.getDisplayName();
            String personEmail = acct.getEmail();
        }
    }
}