package com.uygulama.stajevi.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.uygulama.stajevi.R;


public class NewsReadFragment extends Fragment {

    private TextView title;
    private  TextView content;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String t = getArguments().getString("TITLE");
        String c= getArguments().getString("CONTENT");
        // Inflate the layout for this fragment
        View root= inflater.inflate(R.layout.fragment_news_read, container, false);
        title=(TextView)root.findViewById(R.id.NEWS_TITLE);
        content=(TextView)root.findViewById(R.id.NEWS_DESCRIPTION);

        title.setText(Html.fromHtml(t));
        content.setText(Html.fromHtml(c));

        return root;
    }
    @Override
    public void onResume() {
        super.onResume();
        AppCompatActivity mainactivity= ((AppCompatActivity) getContext());
        mainactivity.getSupportActionBar().setTitle("Haber Okuma");
    }


}
