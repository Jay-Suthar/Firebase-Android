package com.example.jaythegreat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText login_email;
    private EditText login_pass;
    private Button login_btn;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_btn = (Button) findViewById(R.id.login);
        login_email = (EditText) findViewById(R.id.loginEmail);
        login_pass = (EditText) findViewById(R.id.LoginPass);
        auth = FirebaseAuth.getInstance();

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = login_email.getText().toString();
                String password = login_pass.getText().toString();
                loginUser(email,password);
            }
        });


    }

    private void loginUser(String email, String password) {
        auth.signInWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(LoginActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this,MainPageActivity.class));
                finish();
            }
        });
    }
}