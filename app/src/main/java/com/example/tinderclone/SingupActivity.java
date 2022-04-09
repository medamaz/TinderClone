package com.example.tinderclone;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.tinderclone.FireBase.DataReadAnDWrite;
import com.example.tinderclone.Frament_Maneger.singup1frg;
import com.example.tinderclone.Frament_Maneger.singup2frg;
import com.example.tinderclone.Frament_Maneger.singup3frg;
import com.example.tinderclone.Login.Singup;
import com.example.tinderclone.Login.ValidationHelper;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.time.Year;

public class SingupActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    Singup user;
    String gender ="Man";
    String birthday;
    int year,month,day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        mAuth = FirebaseAuth.getInstance();

        user = new Singup();

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragmentlay, new singup1frg(),"one");
        fragmentTransaction.commit();

        FragmentManager fragmentManager=getSupportFragmentManager();
        fragmentManager.registerFragmentLifecycleCallbacks(new FragmentManager.FragmentLifecycleCallbacks() {
            @Override
            public void onFragmentViewCreated(@NonNull FragmentManager fm, @NonNull Fragment f, @NonNull View v, @Nullable Bundle savedInstanceState) {
                super.onFragmentViewCreated(fm, f, v, savedInstanceState);
                Fragment currentFragment = fm.findFragmentById(R.id.fragmentlay);
                if(currentFragment.getTag().equals("one"))
                {
                    fragmentOne(currentFragment);
                }
                else if(currentFragment.getTag().equals("two"))
                {
                    fragmentTwo(currentFragment);
                }
                else if(currentFragment.getTag().equals("tree"))
                {
                    fragmentTree(currentFragment);
                }
            }
        },true);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void fragmentOne(Fragment currentFragment){
        try {
            Button cnt = (Button) currentFragment.getView().findViewById(R.id.cnt1);
            EditText email =(EditText) currentFragment.getView().findViewById(R.id.Email_singup);
            EditText pass =(EditText) currentFragment.getView().findViewById(R.id.Pass_singup);
            EditText cpass =(EditText) currentFragment.getView().findViewById(R.id.Confirm_pass);
            cnt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (ValidationHelper.Validate(email.getText().toString(),pass.getText().toString(),cpass.getText().toString())){
                        user.setEmail(email.getText().toString());
                        user.setPassword(pass.getText().toString());
                        createAccount(email.getText().toString(),pass.getText().toString());
                    }
                }
            });
        }
        catch (Exception ex){
            toastGen(ex.getMessage());
        }
    }

    private void fragmentTwo(Fragment currentFragment){
        try {
            EditText username = (EditText) currentFragment.getView().findViewById(R.id.username);
            EditText firstname = (EditText) currentFragment.getView().findViewById(R.id.first_name);
            EditText lastname = (EditText) currentFragment.getView().findViewById(R.id.last_name);
            Button continue1 =(Button) currentFragment.getView().findViewById(R.id.cnt2);
            continue1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!username.getText().toString().equals("") && !firstname.getText().toString().equals("") && !lastname.getText().toString().equals("")){
                        user.setUsername(username.getText().toString());
                        user.setFirstname(firstname.getText().toString());
                        user.setLastname(lastname.getText().toString());
                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragmentlay, new singup3frg(), "tree");
                        fragmentTransaction.commit();
                    }
                    else {
                        toastGen("Please Don't Leave Any champ Vide");
                    }

                }
            });
        }
        catch (Exception ex){
            toastGen(ex.getMessage());
        }

    }

    private void fragmentTree(Fragment currentFragment){
        try {

            dateController(currentFragment.getView());
            RadioGroup rd = currentFragment.getView().findViewById(R.id.raiogroup);
            rd.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    if(i==1)
                        gender="Man";
                    else if(i==2)
                        gender = "Woman";
                }
            });
            Button continue1 =(Button) currentFragment.getView().findViewById(R.id.Singupfinal);
            continue1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(!gender.equals("") && !birthday.equals("")){
                        user.setGender(gender);
                        user.setBirthday(birthday);

                        DataReadAnDWrite.writeUserToDataBase(user);

                        moveToMain();
                    }
                    else{
                        toastGen("Vide Champ");
                     }
                }
            });
        }
        catch (Exception exception){
            toastGen(exception.getMessage());
        }
    }

    private void dateController(View view){
        try {
            EditText et1 =view.findViewById(R.id.day);
            EditText et2 =view.findViewById(R.id.month);
            EditText et3 =view.findViewById(R.id.Year);
            //check if Year is above the current year and move the next field when current full
            et3.addTextChangedListener(new TextWatcher() {
                public void onTextChanged(CharSequence s, int start,int before, int count) {
                    // TODO Auto-generated method stub
                    if(et3.getText().toString().length()==4)
                    {
                        et2.requestFocus();
                    }
                }
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    // TODO Auto-generated method stub
                }
                @RequiresApi(api = Build.VERSION_CODES.O)
                public void afterTextChanged(Editable s) {
                    if(et3.getText().toString().length()!=0) {
                        year = Integer.parseInt(et3.getText().toString());
                        if(year > Integer.parseInt(String.valueOf(Year.now()))){
                            et3.requestFocus();
                            toastGen("Enter a Valid Year");
                        }
                    }
                }
            });
            //check if month is between 1 and 12 and move the next field when current full
            et2.addTextChangedListener(new TextWatcher() {
                public void onTextChanged(CharSequence s, int start,int before, int count) {
                    // TODO Auto-generated method stub
                    if(et2.getText().toString().length()==2)
                    {
                        et1.requestFocus();
                    }
                    if(et2.getText().toString().length()==0)
                    {
                        et3.requestFocus();
                    }
                }
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    // TODO Auto-generated method stub
                }
                public void afterTextChanged(Editable s) {
                    if(et2.getText().toString().length()==2){
                        month = Integer.parseInt(et2.getText().toString());
                        if(month>12 || month<1){
                            et2.requestFocus();
                            toastGen("Enter a Valid Month");
                        }
                    }
                }
            });
            //check if day is between 1 and 31 and verify with the selected month and remove focus from current field
            et1.addTextChangedListener(new TextWatcher() {
                public void onTextChanged(CharSequence s, int start,int before, int count) {
                    // TODO Auto-generated method stub
                    if(et1.getText().toString().length()==2)
                    {
                        et1.clearFocus();
                    }
                    if(et1.getText().toString().length()==0)
                    {
                        et2.requestFocus();
                    }
                }
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                    // TODO Auto-generated method stub

                }
                @RequiresApi(api = Build.VERSION_CODES.O)
                public void afterTextChanged(Editable s) {
                    // TODO Auto-generated method stub
                    if(et1.getText().toString().length()==2){
                        day = Integer.parseInt(et1.getText().toString());
                        if (Singup.isValid(year +"-"+ month +"-"+ day)){
                            birthday = day + "/" +month + "/" +year;
                        }
                        else {
                            et1.requestFocus();
                            toastGen("Enter a Valid Day");
                        }
                    }
                }

            });
        }
        catch (Exception e){
            toastGen(e.getMessage());
        }
    }

    private void createAccount(String email, String password) {
        // [START create_user_with_email]
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);

                            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                            fragmentTransaction.add(R.id.fragmentlay, new singup2frg(),"two");
                            fragmentTransaction.commit();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("TAG", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SingupActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
                    }
                });
        // [END create_user_with_email]
    }

    private static void updateUI(FirebaseUser currentuser) {
    }

    public void toastGen(String msg) {

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    public void moveToMain(){
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            getSupportFragmentManager().beginTransaction().remove(getSupportFragmentManager().findFragmentById(R.id.fragmentlay)).commit();
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
        }
        else {
            Toast.makeText(this,"erreur",Toast.LENGTH_SHORT).show();
        }

    }
}

