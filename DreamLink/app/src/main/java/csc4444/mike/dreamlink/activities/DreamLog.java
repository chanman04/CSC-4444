package csc4444.mike.dreamlink.activities;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import butterknife.Bind;
import butterknife.ButterKnife;
import csc4444.mike.dreamlink.DreamLink;
import csc4444.mike.dreamlink.R;
import csc4444.mike.dreamlink.components.Dream;

/**
 * Created by Mike on 10/1/15.
 */
public class DreamLog extends Activity {

    @Bind(R.id.toolbar) Toolbar mainToolbar;

    private ParseQueryAdapter<ParseObject> mainAdapter;
    private DreamAdapter dreamAdapter;
    private ListView listView;
    private String userName = "captaincrunch";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dream_view);
        //ButterKnife.bind(this);

        mainAdapter = new ParseQueryAdapter<ParseObject>(this, "DREAM");
        mainAdapter.setTextKey("DREAM_TITLE");
        mainAdapter.setTextKey("DREAM_ENTRY");

        //subclass of ParseQueryAdapter
        dreamAdapter = new DreamAdapter(this, userName);

        listView = (ListView) findViewById(R.id.dream_list);
        //listView.setAdapter(mainAdapter); //this shows but only the entries
        //mainAdapter.loadObjects();
        listView.setAdapter(dreamAdapter); //nothing shows when using this?
        dreamAdapter.loadObjects();

        //Get a instance off the app to pull the global username we are storing for this app user
        //DreamLink dreamLink = DreamLink.getInstance();

        //ParseQuery to pull all this user's dreams using the global username we pulled up there ^
        //ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery("DREAM");
        //parseQuery.whereEqualTo("USER", userName);

//        dreamLogLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//        });
    }
}
