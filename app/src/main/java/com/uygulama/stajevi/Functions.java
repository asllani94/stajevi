package com.uygulama.stajevi;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.uygulama.stajevi.interfaces.Bridge;


public class Functions {


    public View createbackToolbar(Context context,View v,String title, final Bridge bridge){
        Toolbar toolbar=(Toolbar)v.findViewById(R.id.tool_bar);
        toolbar.setTitle(title);
        Button back=(Button)toolbar.findViewById(R.id.backbtn);
        back.setText(title);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bridge.backButton();
            }
        });

        AppCompatActivity mainactivity= ((AppCompatActivity) context);
        mainactivity.setSupportActionBar(toolbar);
        mainactivity.getSupportActionBar().setDisplayShowTitleEnabled(false);

        return  v;
    }



    //create and run fragment for our application
    public boolean createFragment(Context c,Fragment fragment,int container_id){

        if (fragment != null) {

            AppCompatActivity activity= ((AppCompatActivity) c);


            FragmentManager fragmentManager = activity.getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(container_id, fragment).addToBackStack("Stack");
            fragmentTransaction.commit();


            return true;
        }
        else
            return false;
    }

}
