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
//    @Bind(R.id.dream_log_LV) ListView dreamLogLV;

    private List<Dream> dreamLog = new ArrayList<Dream>();
    private String userName = "captaincrunch";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dream_view);
//        ButterKnife.bind(this);

        ListView lv = (ListView) findViewById(R.id.listView1);

        //setSupportActionBar(mainToolbar);
        //getSupportActionBar().setTitle("Dream Log");

        //Get a instance off the app to pull the global username we are storing for this app user
        DreamLink dreamLink = DreamLink.getInstance();

        final DreamAdapter adp = new DreamAdapter(this, R.layout.item_layout, dreamLog);
        lv.setAdapter(adp);


        //ParseQuery to pull all this user's dreams using the global username we pulled up there ^
        ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery("DREAM");
        parseQuery.whereEqualTo("USER", userName);
        parseQuery.findInBackground(new FindCallback<ParseObject>() {

            //Error check for ParseQuery
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e == null) {
                    for (int i = 0; i<objects.size(); i++) {

//                        Base case we setup to query from Parse take Dream objects from cloud and set
//                        their values to a local Dream object we display in our ListView.
//
//                        In the future we to setup to query for specific Dream objects
//
                        Dream dreamObj = new Dream();
                        dreamObj.setTitle(objects.get(i).get("USER_TITLE").toString());
                        dreamObj.setEntry(objects.get(i).get("USER_ENTRY").toString());

                        //Finally we add Dream objects into our Stack so we can pop them off one by one and display
                        dreamLog.add(dreamObj);
                        adp.notifyDataSetChanged();



                        Log.d("score", "Retrieved " + objects.size() + " scores");
                    }

                } else {
                    Log.d("score", "Error: " + e.getMessage());
                }
            }
        });



//        dreamLogLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//        });

    }


}
