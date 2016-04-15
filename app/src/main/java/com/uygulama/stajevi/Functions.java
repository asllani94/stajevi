package com.uygulama.stajevi;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;



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

}
