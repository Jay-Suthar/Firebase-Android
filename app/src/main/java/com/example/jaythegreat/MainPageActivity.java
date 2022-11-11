package com.example.jaythegreat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainPageActivity extends AppCompatActivity {

    private Button logout;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        logout = (Button) findViewById(R.id.logoutBtn);
        tv = (TextView) findViewById(R.id.userDetails);
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if(user!=null)
        {
            String email = user.getEmail();
            String pass = user.getUid();

            tv.setText(email + " " + pass);
        }
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(MainPageActivity.this, "LoggedOut Syccessfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainPageActivity.this,MainActivity.class));
            }
        });
    }
}