package csc4444.mike.dreamlink.activities;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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

    private DreamAdapter dreamAdapter;
    private ListView listView;
    private Button createDreamButton;

    private String userName = "captaincrunch";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dream_view);
        //ButterKnife.bind(this);

        dreamAdapter = new DreamAdapter(this, userName);
        //dreamFragment = new DreamFragment();
        //dreamFragment.setArguments(???);

        listView = (ListView) findViewById(R.id.dream_list);
        listView.setAdapter(dreamAdapter);
        dreamAdapter.loadObjects();

        //createDreamButton = (Button) findViewById(R.id.create_dream_button);

        //Get a instance off the app to pull the global username we are storing for this app user
        //DreamLink dreamLink = DreamLink.getInstance();

        //ParseQuery to pull all this user's dreams using the global username we pulled up there ^
        //ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery("DREAM");
        //parseQuery.whereEqualTo("USER", userName);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //String item = (String) parent.getItemAtPosition(position); this doesnt work
                //String item = dreamAdapter.getItem(position).toString();
                //Toast.makeText(DreamLog.this, "CLICK: "+item, Toast.LENGTH_SHORT).show(); //how to get actual object values and stuff?
                //below change RecordDream.class to whatever Dream Interpretation class that is made

                String parseObjectId = dreamAdapter.getItem(position).getObjectId();

                Intent intent = new Intent(DreamLog.this, DreamInterpreter.class);
                intent.putExtra("parse_obj_id", parseObjectId);
                startActivity(intent);

                //or just switch adapter to new layout? what do?
            }
        });

        /*createDreamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(DreamLog.this, RecordDream.class);
                intent2.putExtra("userName", userName);
                startActivity(intent2);
            }
        });*/
    }
}
