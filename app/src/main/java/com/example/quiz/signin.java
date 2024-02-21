package com.example.quiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.quiz.databinding.ActivitySigninBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signin extends AppCompatActivity {
FirebaseAuth auth;
ActivitySigninBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySigninBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        auth=FirebaseAuth.getInstance();
        binding.signbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email,pass;
                email=binding.mail.getText().toString();
                pass=binding.password.getText().toString();
                auth.signInWithEmailAndPassword( email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(signin.this, "success", Toast.LENGTH_SHORT).show();
                            Intent i=new Intent(signin.this,MainActivity.class);
                            startActivity(i);
                            finish();
                        }
                        else {
                            Toast.makeText(signin.this, task.getException().getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        binding.createacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(signin.this,sign_up.class));
            }
        });
    }
}