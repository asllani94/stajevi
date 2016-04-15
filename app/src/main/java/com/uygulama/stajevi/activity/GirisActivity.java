package com.uygulama.stajevi.activity;



import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.uygulama.stajevi.interfaces.Bridge;
import com.uygulama.stajevi.R;
import com.uygulama.stajevi.fragment.LoginFragment;
import com.uygulama.stajevi.fragment.RegisterFragment;
import com.uygulama.stajevi.fragment.UserLogin;


public class GirisActivity extends AppCompatActivity implements Bridge {

    FragmentManager trans = getFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);

        //setting toolbar instead of action bar


        //Fragment to select what to do:login,register or register with facebook
        Fragment fragment = new LoginFragment();
        trans.beginTransaction().add(R.id.main, fragment, "LOGIN").commit();

    }


    @Override
    public void LoginBtnClicked() {

        //When Login button is clicked do the following


        Fragment userLogin = new UserLogin();//create a new login for the user
       /* RelativeLayout rl=(RelativeLayout)findViewById(R.id.main);

            rl.setBackgroundColor(R.color.defaultThemeGray);*/



        //this line replaces the current fragment with the User Login fragment...and puts the old fragment in a stack
        trans.beginTransaction().replace(R.id.main, userLogin, "USERLOGIN").addToBackStack("LOGIN").commit();


    }

    @Override
    public void RegisterBtnCLicked() {
        //When register button is clicked do the following

        Fragment register = new RegisterFragment();//create a new login for the user


        //this line replaces the current fragment with the User Login fragment...and puts the old fragment in a stack
        trans.beginTransaction().replace(R.id.main, register, "REGISTER").addToBackStack("USERLOGIN").commit();

    }

    @Override
    public void RegisterwithFBClicked() {
        Intent i=new Intent(GirisActivity.this,MainActivity.class);
        startActivity(i);
        finish();

    }


    //when hardware backbutton is pressed..get the fragment added to stack
    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }

    //when our toolbar backbutton is pressed  get the fragment last added to stack
    @Override
    public void backButton() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        }

    }

}