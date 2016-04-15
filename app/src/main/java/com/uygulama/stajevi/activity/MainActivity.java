package com.uygulama.stajevi.activity;



import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.uygulama.stajevi.Functions;
import com.uygulama.stajevi.fragment.DrawerFragment;
import com.uygulama.stajevi.fragment.NewsFragment;
import com.uygulama.stajevi.R;
import com.uygulama.stajevi.fragment.NewsReadFragment;
import com.uygulama.stajevi.interfaces.NewsInterface;


public class MainActivity extends AppCompatActivity implements DrawerFragment.FragmentDrawerListener,NewsInterface{

    private DrawerFragment drawerFragment;
    private int container_id=R.id.container_body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar mToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        mToolbar.setTitle("Home");

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        drawerFragment = (DrawerFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if(id == R.id.action_search){
            Toast.makeText(getApplicationContext(), "Search action is selected!", Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {

        displayView(position);
    }

    private void displayView(int position) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch (position) {
            case 0:
                //fragment = new LoginFragment();
                title = getString(R.string.title_profilim);
                break;
            case 1:
                //fragment = new LoginFragment();
                title = getString(R.string.title_staj_ilanlari);
                break;
            case 2:
               fragment=new NewsFragment();
                break;
            case 3:
                // fragment = new Fragment();
                title = getString(R.string.title_blog);
                break;
            case 4:
                // fragment = new Fragment();
                title = getString(R.string.title_kurslar);
                break;
            case 5:
                // fragment = new Fragment();
                title = getString(R.string.title_iletisim);
                break;

            case 6:
                // fragment = new Fragment();
                title = getString(R.string.title_cikis);
                break;
            default:
                break;
        }

        if (fragment != null) {

            Functions c=new Functions();
            c.createFragment(this,fragment,container_id);
        }

    }


    @Override
    public void transferNews(String title, String content) {
        //Using function class to create a new Fragment
        Functions c=new Functions();

        //Using bundle to pass data from activity to fragment
        Bundle bundle = new Bundle();
        bundle.putString("TITLE", title);
        bundle.putString("CONTENT", content);

        //Creating a new news read fragment and adding bundle to it
        NewsReadFragment newsReadFragment = new NewsReadFragment();
        newsReadFragment.setArguments(bundle);

     //creating and running the new fragment
        c.createFragment(this,newsReadFragment,container_id);

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


}
