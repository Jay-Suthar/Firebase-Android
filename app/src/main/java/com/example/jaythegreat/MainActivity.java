package com.example.jaythegreat;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference dbf;
//    private Button btn_next;
//    private EditText name;
//    private EditText email;
//    private TextView disname;
//    private ListView mUserList;
//    private ArrayList<String> user_name = new ArrayList<>();



    //auth part
    private Button login;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        login = (Button) findViewById(R.id.Login_btn);
        register = (Button) findViewById(R.id.Rrgister_btn);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,RegisterActivity.class));
                finish();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,LoginActivity.class));
                finish();
            }
        });









//        dbf = FirebaseDatabase.getInstance("https://newproj-83d5f-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference().child("Names");
//
//        mUserList = (ListView) findViewById(R.id.user_list);
//
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,user_name);
//        mUserList.setAdapter(arrayAdapter);
//        dbf.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
////                Information info = snapshot.getValue(Information.class);
////                String names = info.getName() + ": " + info.getEmail() ;
//                String val = snapshot.getValue(String.class);
//                user_name.add(val);
//                arrayAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

//        dbf.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                user_name.clear();
//                for(DataSnapshot snapshot1 : snapshot.getChildren())
//                {
////                    Information info = snapshot1.getValue(Information.class);
////                    String nam = info.getName() + ": " + info.getEmail() ;
//                    user_name.add(snapshot1.getValue().toString());
//                }
//                arrayAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });




        // getting a single data
        //        disname = (TextView) findViewById(R.id.dbview);
//
//        dbf.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                String name = snapshot.getValue().toString();
//                disname.setText("Name: "+ name);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });


        //adding the data simple/complex
        //        btn_next = (Button) findViewById(R.id.btn_next);
//        name = (EditText) findViewById(R.id.username);
//        email = (EditText) findViewById(R.id.useremail);
//        btn_next.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String nm = name.getText().toString().trim();
//                String mail = email.getText().toString().trim();
//                String add = nm + "is Having the gmail" + mail;
//
//                // for taking complex data together
//                HashMap<String,String> hp = new HashMap<>(); //use to create object like structure
//                hp.put("Name",nm);
//                hp.put("Email",mail);
//                hp.put("Info",add);
//                dbf.child("Profile").push().setValue(hp).addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        if(task.isSuccessful())
//                        {
//                            Toast.makeText(MainActivity.this,"Stored",Toast.LENGTH_LONG).show();
//                        }
//
//                        else
//                        {
//                            Toast.makeText(MainActivity.this,"Not Stored",Toast.LENGTH_LONG).show();
//                        }
//                    }
//                });
////                dbf.child("User1").child("Name").setValue("Jay Suthar");
////                dbf.child("User1").child("Email").setValue("jaysuthar162001@gmail.com");
//
////                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
////                startActivity(intent);
//            }
//        });
    }
}