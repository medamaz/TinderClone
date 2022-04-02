package com.example.tinderclone.Frament_Maneger;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.tinderclone.R;

public class singup2frg extends Fragment {
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.singup2, container, false);
        return view;
    }

    /*private void nextFragment(){
        Button continue1 =(Button) view.findViewById(R.id.cnt2);
        continue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragmentlay,new singup3frg(),"tree");
                fragmentTransaction.commit();

            }
        });
    }*/
}