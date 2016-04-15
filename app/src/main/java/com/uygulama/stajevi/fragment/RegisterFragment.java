package com.uygulama.stajevi.fragment;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uygulama.stajevi.interfaces.Bridge;
import com.uygulama.stajevi.Functions;
import com.uygulama.stajevi.R;


public class RegisterFragment extends Fragment {


    Bridge send;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_register, container, false);


        //Defining the communication bridge
        send = (Bridge) getActivity();



        //Using our function create Toolbar
        Functions fn=new Functions();
        rootView=fn.createbackToolbar(getActivity(),rootView,"Uye Ol",send);

        return rootView;
    }


}
