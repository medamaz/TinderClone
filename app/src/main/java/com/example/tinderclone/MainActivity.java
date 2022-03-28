package com.example.tinderclone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent switchActivityIntent = new Intent(this, LoginMethodActivity.class);
        startActivity(switchActivityIntent);
    }
    public void toastGen(String msg){

        Toast.makeText(this,msg, Toast.LENGTH_LONG).show();
    }
}