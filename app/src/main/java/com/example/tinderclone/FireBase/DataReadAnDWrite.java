package com.example.tinderclone.FireBase;

import com.example.tinderclone.Login.Singup;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DataReadAnDWrite {
    public static FirebaseAuth mAuth = FirebaseAuth.getInstance() ;
    private static DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();;

    public static void writeUserToDataBase(Singup user) {
        mDatabase.child(mAuth.getCurrentUser().getUid()).setValue(user);
    }
}
