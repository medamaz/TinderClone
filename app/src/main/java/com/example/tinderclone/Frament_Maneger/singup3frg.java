package com.example.tinderclone.Frament_Maneger;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.tinderclone.Login.Singup;
import com.example.tinderclone.R;

import java.time.Year;

public class singup3frg extends Fragment {
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.singup3, container, false);
        return view;
    }
    /*private void nextFragment(){
        Button continue1 =(Button) view.findViewById(R.id.Singupfinal);
        continue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                //fragmentTransaction.replace(R.id.fragmentlay,new singup2frg());
                //fragmentTransaction.commit();
            }
        });
    }

    private void date_Gestion(){
        EditText et1 =view.findViewById(R.id.day);
        EditText et2 =view.findViewById(R.id.month);
        EditText et3 =view.findViewById(R.id.Year);
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
                        bithday = day + "/" +month + "/" +year;
                    }
                    else {
                        et1.requestFocus();
                        toastGen("Enter a Valid Day");
                    }
                }
            }

        });
    }*/
}