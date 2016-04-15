package com.uygulama.stajevi;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class LoginFragment extends Fragment {

    private Bridge send;//comunication Inteface to bind data to Giris Activity
    private Button logbtn;//login button
    private Button registerbtn;//login button
    private Button logbyFB;//login button
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);



        send = (Bridge) getActivity();//bind activity with fragments defining a new bridge

        logbtn = (Button) rootView.findViewById(R.id.btnLogin);//Log in button
        logbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                  send.LoginBtnClicked();


            }
        });

        registerbtn=(Button)rootView.findViewById(R.id.registerBtn);//Register button
        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                send.RegisterBtnCLicked();

            }
        });

        logbyFB=(Button)rootView.findViewById(R.id.btnFB);//login By facebook button
        logbyFB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                send.RegisterwithFBClicked();
            }
        });

        return rootView;


    }






}
