package csc4444.mike.dreamlink.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import butterknife.Bind;
import butterknife.ButterKnife;
import csc4444.mike.dreamlink.R;
import csc4444.mike.dreamlink.adapters.DictionaryAdapter;
import csc4444.mike.dreamlink.adapters.DreamAdapter;

/**
 * Created by Mike on 11/25/15.
 */
public class DreamDictionary extends ActionBarActivity {

    @Bind(R.id.toolbar) Toolbar mainToolbar;
    private DictionaryAdapter dictionaryAdapter;
    private ListView listView;
//    private Button createDreamButton;

    private String userName = "captaincrunch";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dream_dictionary);
        ButterKnife.bind(this);

        setSupportActionBar(mainToolbar);
        getSupportActionBar().setTitle("Dream Dictionary");

        dictionaryAdapter = new DictionaryAdapter(this, userName);
        listView = (ListView) findViewById(R.id.dream_list);
        listView.setAdapter(dictionaryAdapter);
        dictionaryAdapter.loadObjects();

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

                String parseObjectId = dictionaryAdapter.getItem(position).getObjectId();

                Intent intent = new Intent(DreamDictionary.this, DreamTerm.class);
                intent.putExtra("parse_obj_id", parseObjectId);
                startActivity(intent);

                //or just switch adapter to new layout? what do?
            }
        });

    }
}
