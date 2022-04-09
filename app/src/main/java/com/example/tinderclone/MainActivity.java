package com.example.tinderclone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button logOut = findViewById(R.id.button);
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                moveToLoginMethode();
            }
        });
    }
    public void moveToLoginMethode(){
        Intent intent = new Intent(this, LoginMethodActivity.class);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }
    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}