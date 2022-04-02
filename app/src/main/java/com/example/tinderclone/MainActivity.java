package com.example.tinderclone;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.IDNA;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tinderclone.Login.Singup;

public class MainActivity extends AppCompatActivity {
    private static Singup singup;
    public static void setSingup(Singup singup1) {
        singup = singup1;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        TextView ed = findViewById(R.id.textView2);
        ed.setText(singup.toString());
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}