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
public class DreamInterpreter extends ActionBarActivity{



    @Bind(R.id.toolbar) Toolbar mainToolbar;

    //Save the IBM Question and Answer username and password to access the service
    private final String username = "e0135a85-6fc6-4703-ae61-daf5170aee1a";
    private final String password = "zpAgWm05ktz0X";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dream_interpreter);
        ButterKnife.bind(this);


        setSupportActionBar(mainToolbar);
        getSupportActionBar().setTitle("Dream Interpreter");

/*      QuestionAndAnswer service = new QuestionAndAnswer();
        service.setUsernameAndPassword(username, password);
        service.setDataset(QuestionAndAnswerDataset.HEALTHCARE);
        WatsonAnswer watsonAnswers = service.ask("What is HIV?");
        System.out.println(watsonAnswers);
*/


    }



}
