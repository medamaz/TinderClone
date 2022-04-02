package com.example.tinderclone.Frament_Maneger;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.tinderclone.R;

public class singup2frg extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.singup2, container, false);
       nextFragment(view);
        return view;
    }
    private void nextFragment(View view){
        Button continue1 =(Button) view.findViewById(R.id.cnt2);
        continue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragmentlay,new singup3frg());
                fragmentTransaction.commit();

            }
        });
    }
}