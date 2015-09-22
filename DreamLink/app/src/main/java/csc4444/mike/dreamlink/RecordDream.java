package csc4444.mike.dreamlink;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseObject;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Mike on 9/22/15.
 */
public class RecordDream extends ActionBarActivity {


    @Bind(R.id.toolbar) Toolbar mainToolbar;
    @Bind(R.id.dream_title_et) EditText dreamTitleET;
    @Bind(R.id.dream_et) EditText recordDreamET;
    @Bind(R.id.submit_dream_button) Button submitDreamButton;

    private String dreamTitle = "";
    private String dreamEntry = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_dream);
        ButterKnife.bind(this);

        setSupportActionBar(mainToolbar);
        getSupportActionBar().setTitle("Post Your Dream");

        dreamTitleET.setHint("Give your dream a title");
        recordDreamET.setHint("Record your dream");


        submitDreamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{

                    if(recordDreamET.getText().toString().isEmpty()){
                        recordDreamET.setError("You forgot to enter your dream!");

                    }else{
                        dreamTitle = (dreamTitleET.getText().toString());
                        dreamEntry = (recordDreamET.getText().toString());


                        ParseObject userDream = new ParseObject("DREAM");
                        userDream.put("DREAM_TITLE",dreamTitle);
                        userDream.put("DREAM_ENTRY",dreamEntry);
                        userDream.saveInBackground();
                        Toast.makeText(RecordDream.this, "Thanks for sharing your dream",Toast.LENGTH_SHORT).show();
                    }

                }catch(Exception e){

                    e.printStackTrace();
                    Toast.makeText(RecordDream.this, "There was a error recording your dream",Toast.LENGTH_SHORT).show();
                    return;

                }
            }

        });



    }
}
