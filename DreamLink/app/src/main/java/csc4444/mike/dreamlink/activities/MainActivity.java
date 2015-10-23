package csc4444.mike.dreamlink.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


import com.ibm.mobile.services.core.IBMBluemix;

import java.net.MalformedURLException;

import butterknife.Bind;
import butterknife.ButterKnife;
import csc4444.mike.dreamlink.R;

public class MainActivity extends ActionBarActivity implements {


    @Bind(R.id.toolbar)
    Toolbar mainToolbar;
    @Bind (R.id.nav_drawer_layout)
    DrawerLayout navDrawerLayout;
    private ActionBarDrawerToggle navDrawerToggle;@Bind (R.id.nav_drawer_list)
    ListView navDrawerList;
    private ArrayAdapter<String> navDrawerAdapter;
    private String [] navTitlesAdapter = {"Post Your Dream","Interpret Your Dreams",};

    private final String bluemixAppRoute = "http://dreams.mybluemix.net\n";
    private final String bluemixAppGUID = "dd2f777b-4321-4625-90ff-25ddc6a851c8\n";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        IBMBluemix.initialize(this.getApplicationContext(),bluemixAppGUID,"7kozH9C8QTyuPZzZFv7LEg",bluemixAppRoute);


        setSupportActionBar(mainToolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        mainToolbar.getResources().getColor(R.color.primarycolor);

        navDrawerLayout = (DrawerLayout) findViewById(R.id.nav_drawer_layout);
        navDrawerLayout.setDrawerListener(navDrawerToggle);

        navDrawerAdapter = new ArrayAdapter<String>( MainActivity.this, android.R.layout.simple_list_item_1, navTitlesAdapter);
        navDrawerList.setAdapter(navDrawerAdapter);

        navDrawerToggle = new ActionBarDrawerToggle(this, navDrawerLayout, mainToolbar, R.string.drawer_open, R.string.drawer_close){

            //Method that handles open/close of drawer
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

            }
        };
        navDrawerLayout.setDrawerListener(navDrawerToggle);
        navDrawerList.setOnItemClickListener(new NavDrawerListener());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

        return super.onOptionsItemSelected(item);
    }
    private class NavDrawerListener implements android.widget.AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);

        }
        //Method detailing functionality for click
        private void selectItem(int position){

            switch (position) {
                case 1:
                    Intent recordNavIntent = new Intent(MainActivity.this, RecordDream.class);
                    startActivity(recordNavIntent);
                    break;
                case 2:
                    Intent logNavIntent = new Intent(MainActivity.this, DreamLog.class);
                    startActivity(logNavIntent);
                    break;

                default:
            }

        }
    }
}
