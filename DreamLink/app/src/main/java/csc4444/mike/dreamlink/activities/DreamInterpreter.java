package csc4444.mike.dreamlink.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import java.net.HttpURLConnection;

import javax.net.ssl.HttpsURLConnection;

import butterknife.Bind;
import butterknife.ButterKnife;
import csc4444.mike.dreamlink.R;





/**
 * This is the class for Dream Interpretation. This activity is going to populate the view with the
 * user's Dream object they have created.
 */
public class DreamInterpreter extends ActionBarActivity {


//
//    {
//        "credentials": {
//        "url": "https://gateway.watsonplatform.net/question-and-answer-beta/api",
//                "username": "e0135a85-6fc6-4703-ae61-daf5170aee1a",
//                "password": "pAgWm05ktz0X"
//    }
//    }
    @Bind(R.id.toolbar) Toolbar mainToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dream_interpreter);
        ButterKnife.bind(this);


        setSupportActionBar(mainToolbar);
        getSupportActionBar().setTitle("Dream Interpreter");



    }



}
