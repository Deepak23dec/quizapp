package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quiz.databinding.ActivitySignUpBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class sign_up extends AppCompatActivity {
ActivitySignUpBinding binding;
FirebaseAuth auth;
FirebaseFirestore database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        auth=FirebaseAuth.getInstance();
        database=FirebaseFirestore.getInstance();
        binding.signbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email,pass,name,refercode;
                email=binding.mail.getText().toString();
                pass=binding.password.getText().toString();
               name=binding.name.getText().toString();
                refercode=binding.refercode.getText().toString();
                Users user=new Users(email,pass,name,refercode);
                auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            String uid=task.getResult().getUser().getUid();
                            database.collection("users")
                                    .document(uid)
                                    .set(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if(task.isSuccessful()){
                                                Intent i=new Intent(sign_up.this,MainActivity.class);
                                                startActivity(i);
                                                finish();
                                            }
                                            else{
                                                Toast.makeText(sign_up.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });
                        }
                        else {
                            Toast.makeText(sign_up.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
        binding.alreadracc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(sign_up.this,signin.class));
            }
        });
    }
}