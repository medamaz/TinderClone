package com.example.tinderclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

import com.example.tinderclone.Frament_Maneger.singup1frg;

public class SingupActivity extends AppCompatActivity {
    int day;
    int month;
    int year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragmentlay, new singup1frg());
        fragmentTransaction.commit();
    }

    public void toastGen(String msg) {

        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}