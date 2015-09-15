package csc4330.mike.dreamlink.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import csc4330.mike.dreamlink.R;

/**
 * Created by Mike on 9/4/15.
 */
public class RecordDream extends ActionBarActivity {


    @Bind(R.id.toolbar) Toolbar mainToolbar;
    @Bind(R.id.dream_et) EditText recordDreamET;
    @Bind(R.id.submit_dream_button) Button submitDreamButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dream_feed);
        ButterKnife.bind(this);

        setSupportActionBar(mainToolbar);
        getSupportActionBar().setTitle("Post Your Dream");

        recordDreamET.setHint("Record your dream");

        submitDreamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{

                    if(recordDreamET.getText().toString().isEmpty()){
                        recordDreamET.setError("You forgot to enter your dream!");

                    }

                }catch(IOException e){



                }
            }

        });



    }
}
