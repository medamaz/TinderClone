package com.example.tinderclone.Frament_Maneger;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tinderclone.Login.ValidationHelper;
import com.example.tinderclone.R;

public class singup1frg extends Fragment {
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.singup1, container, false);
        return view;
    }
    /*private void nextFragment(){
        EditText email =(EditText) view.findViewById(R.id.Email_singup);
        EditText pass =(EditText) view.findViewById(R.id.Pass_singup);
        EditText cpass =(EditText) view.findViewById(R.id.Confirm_pass);
        //toastGen(String.valueOf(ValidationHelper.Validate(email.getText().toString(),pass.getText().toString(),cpass.getText().toString())),view);
        Button continue1 =(Button) view.findViewById(R.id.cnt1);
        continue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email =email.getText().toString();
                String Pass =pass.getText().toString();
                String Cpass =cpass.getText().toString();
                if (!ValidationHelper.Validate(Email,Pass,Cpass)){
                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentlay,new singup2frg(),"two");
                    fragmentTransaction.commit();
                }

            }
        });
    }*/
    public void toastGen(String msg){

        Toast.makeText(view.getContext(),msg, Toast.LENGTH_LONG).show();
    }
}