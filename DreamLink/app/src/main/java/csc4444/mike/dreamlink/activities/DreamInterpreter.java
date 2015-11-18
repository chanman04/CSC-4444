package csc4444.mike.dreamlink.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import butterknife.Bind;
import csc4444.mike.dreamlink.R;

/**
 * Created by Miles on 11/16/2015.
 */
public class DreamInterpreter extends Activity {

    @Bind(R.id.toolbar) Toolbar mainToolbar;

    private TextView dreamTitle;
    private TextView dreamEntry;
    private Button interpretButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dream_interpret_layout);

        dreamTitle = (TextView) findViewById(R.id.dream_title);
        dreamEntry = (TextView) findViewById(R.id.dream_entry);
        interpretButton = (Button) findViewById(R.id.interpret_button);

        //dreamTitle = (cast as what? TextView?) findViewById(R.id.

        String parseObjId = getIntent().getStringExtra("parse_obj_id");
        ParseQuery<ParseObject> query = ParseQuery.getQuery("DREAM"); //which query to pull here?
        query.getInBackground(parseObjId, new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject item, ParseException e) {
                if (e == null) {
                    // item was found
                    dreamTitle.setText(item.getString("DREAM_TITLE"));
                    dreamEntry.setText(item.getString("DREAM_ENTRY"));
                }else{
                    Toast.makeText(DreamInterpreter.this, "FAILED TO RETRIEVE DREAM", Toast.LENGTH_LONG).show();
                }
            }
        });


        interpretButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //do stuff here
            }
        });
    }
}
