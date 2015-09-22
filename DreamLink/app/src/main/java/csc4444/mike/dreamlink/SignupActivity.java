package csc4444.mike.dreamlink;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseUser;
import com.parse.SignUpCallback;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Mike on 9/22/15.
 */
public class SignupActivity extends ActionBarActivity{


    @Bind(R.id.user_ET) EditText usernameET;
    @Bind(R.id.password_ET) EditText passwordET;
    @Bind(R.id.email_ET) EditText emailET;
    @Bind(R.id.submit_button) Button submitButton;
    @Bind(R.id.pick_login_TV) TextView pickLoginTV;
    @Bind(R.id.login_button) Button loginButton;
    @Bind(R.id.error_TV)TextView errorResponseTV;

    private String userField ="";
    private String passwordField ="";
    private String emailField ="";



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);

        usernameET.setHint("Username");
        passwordET.setHint("Password");
        emailET.setHint("Email");



        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ParseUser user = new ParseUser();
                userField = usernameET.getText().toString();
                passwordField = passwordET.getText().toString();
                emailField = emailET.getText().toString();

                createParseUser(userField, passwordField, emailField);

//                user.signUpInBackground(new SignUpCallback() {
//
//                    @Override
//                    public void done(ParseException e) {
//
//                        if (e == null){
//                            Intent feedIntent = new Intent(SignupActivity.this, DreamFeed.class);
//                            startActivity(feedIntent);
//                            finish();
//
//                        }else{
//                            switch(e.getCode()){
//                                case ParseException.USERNAME_MISSING:
//                                    usernameET.setError("You must supply a username");
//                                    break;
//                                case ParseException.PASSWORD_MISSING:
//                                    passwordET.setError("You must supply a password");
//                                    break;
//                                case ParseException.EMAIL_MISSING:
//                                    emailET.setError("You must supply a email address");
//                                    break;
//                            }
//
//                        }
//
//                    }
//                });

            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent feedIntent = new Intent(SignupActivity.this, LoginScreen.class);
//                startActivity(feedIntent);
//                finish();
            }
        });

    }
    public void createParseUser(String username, String password, String email) {

        ParseUser user = new ParseUser();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.signUpInBackground(new SignUpCallback() {

            @Override
            public void done(com.parse.ParseException e) {

                if (e == null) {

                    Toast.makeText(SignupActivity.this, "Your account was created successfully!", Toast.LENGTH_SHORT).show();
                    Intent feedIntent = new Intent(SignupActivity.this, RecordDream.class);
                    startActivity(feedIntent);

                } else {
                    Toast.makeText(SignupActivity.this, "Parse didn't get yo shit!", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }

}

