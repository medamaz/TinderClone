package com.example.tinderclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class SingupActivity extends AppCompatActivity {
    int day;
    int month;
    int year;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);
        /*
        EditText et1 =findViewById(R.id.day);
        EditText et2 =findViewById(R.id.month);
        EditText et3 =findViewById(R.id.Year);
        //check if Year is above the current year and move the next field when current full
        et3.addTextChangedListener(new TextWatcher() {
            public void onTextChanged(CharSequence s, int start,int before, int count)
            {
                // TODO Auto-generated method stub
                if(et3.getText().toString().length()==4)
                {
                    et2.requestFocus();
                }
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }

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
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
                if(et1.getText().toString().length()==2){
                    day = Integer.parseInt(et1.getText().toString());
                    if (Singup.isValid(year +"-"+ month +"-"+ day)){
                    }
                    else {
                        et1.requestFocus();
                        toastGen("Enter a Valid Day");
                    }
                }
            }

        });*/
    }
}