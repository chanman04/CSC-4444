package csc4444.mike.dreamlink.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import butterknife.Bind;
import butterknife.ButterKnife;
import csc4444.mike.dreamlink.R;

/**
 * Created by Mike on 11/25/15.
 */
public class DreamTerm extends ActionBarActivity {

    @Bind(R.id.toolbar) Toolbar mainToolbar;
    private TextView dreamTerm;
    private TextView dreamMeaning;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setRetainInstance(true);
        setContentView(R.layout.activity_dream_term);
        ButterKnife.bind(this);

        setSupportActionBar(mainToolbar);
        getSupportActionBar().setTitle("Dream Dictionary");

        dreamTerm = (TextView) findViewById(R.id.dream_term);
        dreamMeaning = (TextView) findViewById(R.id.dream_meaning);

        String parseObjId = getIntent().getStringExtra("parse_obj_id");
        ParseQuery<ParseObject> query = ParseQuery.getQuery("DREAM_DICT"); //which query to pull here?
        query.getInBackground(parseObjId, new GetCallback<ParseObject>() {

            @Override
            public void done(ParseObject item, ParseException e) {
                if (e == null) {
                    // item was found
                    dreamTerm.setText(item.getString("DREAM_TERM"));
                    dreamMeaning.setText(item.getString("DREAM_MEANING"));
                } else {
                    Toast.makeText(DreamTerm.this, "Failed to get dream dictionary from our database", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}
