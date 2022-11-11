package com.example.jaythegreat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    private EditText reg_email;
    private EditText reg_pass;
    private Button regBtn;
    private FirebaseAuth auth;
    private FirebaseDatabase db;
    private DatabaseReference df;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        regBtn = (Button) findViewById(R.id.onclickreg);
        reg_email = (EditText) findViewById(R.id.register_email);
        reg_pass = (EditText) findViewById(R.id.register_pass);

        df = db.getInstance("https://newproj-83d5f-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference();
        auth = FirebaseAuth.getInstance();
        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtEmail = reg_email.getText().toString();
                String txtPassword = reg_pass.getText().toString();

                if (TextUtils.isEmpty(txtEmail) || TextUtils.isEmpty(txtPassword)){
                    Toast.makeText(RegisterActivity.this, "Empty credentials!", Toast.LENGTH_SHORT).show();
                } else if (txtPassword.length() < 6){
                    Toast.makeText(RegisterActivity.this, "Password too short!", Toast.LENGTH_SHORT).show();
                } else {
                    registerUser(txtEmail , txtPassword);
                }
            }
        });

    }

    private void registerUser(String txtEmail, String txtPassword) {
        auth.createUserWithEmailAndPassword(txtEmail,txtPassword).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(RegisterActivity.this, "Registration Successfull", Toast.LENGTH_SHORT).show();
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    if(user!=null)
                    {
                        String email = user.getEmail();
                        String id = user.getUid();
                        String name = email + ", is registered";
                        String details = "The details are" + email;
                        User user2 = new User(email,name,details);
                        df.child(id).setValue(user2);
//                        HashMap<String,String> hp = new HashMap<>();
//                        hp.put("Name",name);
//                        hp.put("Email",name);
//                        hp.put("Info",details);
//                        df.child(id).setValue(hp);
                    }
                    startActivity(new Intent(RegisterActivity.this,MainPageActivity.class));
                }
                else
                {
                    Toast.makeText(RegisterActivity.this, "Not success", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}