package com.example.tinderclone.FireBase;

import android.app.Activity;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.tinderclone.Login.Singup;
import com.example.tinderclone.MainActivity;
import com.example.tinderclone.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DataReadAnDWrite {
    public static FirebaseAuth mAuth = FirebaseAuth.getInstance() ;
    private static DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();;

    public static void writeUserToDataBase(Singup user) {
        mDatabase.child(mAuth.getCurrentUser().getUid()).setValue(user);
    }

    public static void readeUserFromDataBase(Activity activity){
        FirebaseAuth mAuth = FirebaseAuth.getInstance() ;
        FirebaseDatabase.getInstance().getReference().child(mAuth.getCurrentUser().getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Singup user =new Singup();
                user = dataSnapshot.getValue(Singup.class);
                //TextView textView = activity.findViewById(R.id.textView2);
                //textView.setText(user.toString());
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
    public static Singup readeUserFromDataBase(Singup user){
        FirebaseDatabase.getInstance().getReference().child(mAuth.getCurrentUser().getUid()).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //Singup singup =new Singup();
                //singup = dataSnapshot.getValue(Singup.class);
                user.setEmail(dataSnapshot.child("email").getValue().toString());
                user.setUsername(dataSnapshot.child("username").getValue().toString());
                user.setFirstname(dataSnapshot.child("firstname").getValue().toString());
                user.setLastname(dataSnapshot.child("lastname").getValue().toString());
                user.setGender(dataSnapshot.child("gender").getValue().toString());
                user.setBirthday(dataSnapshot.child("birthday").getValue().toString());

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        return user;
    }

}
