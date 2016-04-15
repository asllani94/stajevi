package com.uygulama.stajevi.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


import com.android.volley.Cache;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.uygulama.stajevi.activity.MainActivity;
import com.uygulama.stajevi.interfaces.Bridge;
import com.uygulama.stajevi.R;
import com.uygulama.stajevi.adapter.FeedListAdapter;
import com.uygulama.stajevi.app.AppController;
import com.uygulama.stajevi.interfaces.NewsInterface;
import com.uygulama.stajevi.model.News;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


public class NewsFragment extends Fragment {
    private ListView listView;
    private FeedListAdapter listAdapter;
    private List<News> feedItems;
    private NewsInterface newsInterface;
    private String URL_FEED = "https://stajevi.com/api/Haber/Listele";





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_news, container, false);
        listView = (ListView) rootView.findViewById(R.id.newslist);

        getData();

        listAdapter = new FeedListAdapter(getActivity(), feedItems);


        newsInterface=(NewsInterface)getActivity();

        listView.setAdapter(listAdapter);
listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
      News n=  (News)listAdapter.getItem(position);
        newsInterface.transferNews(n.getNewsTitle(), n.getNewsDescription());
        //Toast.makeText(getContext(),n.getNewsShortTitle(),Toast.LENGTH_SHORT).show();
    }
});

        return rootView;
    }


    private  void  parseJsonFeed(JSONArray response) {


        try {

            for (int i = 0; i < response.length(); i++) {
                JSONObject feedObj = (JSONObject) response.get(i);

                News item = new News();
                // item.setNewsActive(feedObj.getBoolean("NewsActive"));
                //  item.setNewsCreateUserId(feedObj.getString("NewsCreateUserId"));
                item.setNewsDescription(feedObj.getString("NewsDescription"));
                // item.setNewsEndDate(feedObj.getString("NewsEndDate"));
                // item.setNewsID(feedObj.getInt("NewsID"));
                item.setNewsShortTitle(feedObj.getString("NewsShortTitle"));
                item.setNewsStartDate(feedObj.getString("NewsStartDate"));
                item.setNewsTitle(feedObj.getString("NewsTitle"));
                //  item.setNewsType(feedObj.getInt("NewsType"));
                item.setTitleSourceUrl(feedObj.getString("TitleSourceUrl"));
                // item.setTitleType(feedObj.getInt("TitleType"));



                feedItems.add(item);
            }

            // notify data changes to list adapater
            listAdapter.notifyDataSetChanged();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void getData(){
        feedItems = new ArrayList<News>();
        // We first check for cached request
        Cache cache = AppController.getInstance().getRequestQueue().getCache();
        Cache.Entry entry = cache.get(URL_FEED);
        if (entry != null) {
            // fetch the data from cache
            try {
                String data = new String(entry.data, "UTF-8");
                try {
                    parseJsonFeed(new JSONArray(data));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

        } else {
            // making fresh volley request and getting json
            JsonArrayRequest jsonReq=new JsonArrayRequest(URL_FEED, new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray jsonArray) {
                    if (jsonArray != null)
                        parseJsonFeed(jsonArray);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError volleyError) {
                    getData();
                    volleyError.printStackTrace();
                }
            });


            AppController.getInstance().addToRequestQueue(jsonReq);
        }

    }
    @Override
    public void onResume() {
        super.onResume();
        AppCompatActivity mainactivity= ((AppCompatActivity) getContext());
        mainactivity.getSupportActionBar().setTitle("Haberler");
    }



}
