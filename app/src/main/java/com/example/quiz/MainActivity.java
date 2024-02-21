package com.example.quiz;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quiz.databinding.ActivityMainBinding;

import me.ibrahimsn.lib.OnItemSelectedListener;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bottomNav.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public boolean onItemSelect(int i) {

               switch(i){
                   case 0:
                       Toast.makeText(MainActivity.this,"home",Toast.LENGTH_SHORT).show();
                       break;
                       case 1:
                       Toast.makeText(MainActivity.this,"quiz",Toast.LENGTH_SHORT).show();
                       break;
                       case 2:
                       Toast.makeText(MainActivity.this,"wallet",Toast.LENGTH_SHORT).show();
                       break;
                       case 3:
                       Toast.makeText(MainActivity.this,"profile",Toast.LENGTH_SHORT).show();
                       break;
               }
               return true;
            }
              }
        );
    }
}