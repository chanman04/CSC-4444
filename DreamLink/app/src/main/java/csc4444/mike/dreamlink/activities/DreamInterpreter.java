package csc4444.mike.dreamlink.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ibm.watson.developer_cloud.question_and_answer.v1.QuestionAndAnswer;
import com.ibm.watson.developer_cloud.question_and_answer.v1.model.WatsonAnswer;
import com.ibm.watson.developer_cloud.service.WatsonService;

import java.net.HttpURLConnection;

import javax.net.ssl.HttpsURLConnection;

import butterknife.Bind;
import butterknife.ButterKnife;
import csc4444.mike.dreamlink.R;





/**
 * This is the class for Dream Interpretation. This activity is going to populate the view with the
 * user's Dream object they have created. We just need to hook up the Watson Service features to the
 * app. We will allow users to enter text in the EditText field and then parse it to a JSON object
 * this JSON object will be sent to Watson, he will choose the best answer to the question and then
 * send a JSON object back. This JSON object that is sent back will be parsed into text and displayed
 * in a Text View.
 */
public class DreamInterpreter extends Activity{



    @Bind(R.id.toolbar) Toolbar mainToolbar;
    @Bind(R.id.question_field) EditText questionET;
    @Bind(R.id.answer_field) TextView answerTV;
    @Bind(R.id.submit_quest_button) Button submitQuestButton;



    //Save the IBM Question and Answer username and password to access the service
    private final String username = "e0135a85-6fc6-4703-ae61-daf5170aee1a";
    private final String password = "zpAgWm05ktz0X";

    //String to store the EditText input
    public String questionText;
    public String answerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dream_interpreter);
        ButterKnife.bind(this);

        submitQuestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    if(questionET.getText() == null){

                        questionET.setError("You cannot leave the question field blank");
                    }
                    else{

                        /*
                        Here we take the text from the EditText turn it into a Watson Question and
                        returns a Watson Answer that we parse to a string and display in a TextView.
                        Very close to having it working just need some small tweaks. Like so -->

                        QuestionAndAnswer service = new QuestionAndAnswer();
                        service.setUsernameAndPassword("<username>", "<password>");
                        service.setDataset(QuestionAndAnswerDataset.HEALTHCARE);
                        WatsonAnswer watsonAnswers = service.ask("What is HIV?");
                        System.out.println(watsonAnswers);

                         */
                        questionText = questionET.getText().toString();
                        QuestionAndAnswer service = new QuestionAndAnswer();
                        service.setUsernameAndPassword(username, password);
//                        service.setDataset("DREAMS");
                        WatsonAnswer watsonAnswer = service.ask(questionText);
                        answerText = watsonAnswer.toString();
//                        answerTV.getText(answerText.toString());

                        //Temporary toast so I know all of the parsing of the text and sending it worked
                        Toast.makeText(DreamInterpreter.this, "Your question was submitted", Toast.LENGTH_SHORT).show();

                    }

                }
                catch(Exception e){

                    e.printStackTrace();
                    Toast.makeText(DreamInterpreter.this, "There was a error recording your dream", Toast.LENGTH_SHORT).show();
                    return;

                }
            }
        });

    }

}
