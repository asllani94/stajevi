package com.uygulama.stajevi;



import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class UserLogin extends Fragment {
    Bridge send;

    Toolbar toolbar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_user_login, container, false);


        //Defining the communication bridge
        send = (Bridge) getActivity();



        //Using our function create Toolbar
        Functions fn=new Functions();
        rootView=fn.createbackToolbar(getActivity(),rootView,"Log In",send);

        return rootView;
    }





}
