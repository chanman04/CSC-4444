package csc4330.mike.dreamlink.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseUser;
import com.parse.SignUpCallback;

import org.w3c.dom.Text;

import java.text.ParseException;

import butterknife.Bind;
import butterknife.ButterKnife;
import csc4330.mike.dreamlink.R;
import csc4330.mike.dreamlink.components.Contact;

/**
 * Created by Mike on 9/4/15.
 */
public class LoginScreen extends Activity {

    @Bind(R.id.user_ET) EditText userEditText;
    @Bind(R.id.password_ET) EditText passwordEditText;
    @Bind(R.id.email_ET) EditText emailEditText;
    @Bind(R.id.submit_button) Button submitButton;

    private String userField;
    private String passwordField;
    private String emailField;

    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);
        ButterKnife.bind(this);

        userEditText.setHint("username");
        passwordEditText.setHint("password");
        emailEditText.setHint("email");

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {

                    Contact contact = new Contact();

                    //Check for a username
                    if (userEditText.getText().toString().isEmpty()) {
                        userEditText.setError("UserName cannot be blank");
                    //Check for password
                    } else if (passwordEditText.getText().toString().isEmpty()) {
                        passwordEditText.setError("Password field cannot not be blank");
                    //Check for email
                    } else if (emailEditText.getText().toString().isEmpty()) {
                        emailEditText.setError("Email field cannot be blank");
                    //Create the contact and make it into ParseUser
                    } else {
                        contact.setUserName(userEditText.getText().toString());
                        contact.setUserPassword(passwordEditText.getText().toString());
                        contact.setUserEmail(emailEditText.getText().toString());

                        createParseUser(contact);

                    }
                }
                 catch (ParseException e) {

                    Toast.makeText(context, "Please correct your entries and resubmit", Toast.LENGTH_SHORT);
                }


            });
        }

    }

    public static ParseUser createParseUser(Contact contact){

        ParseUser user = new ParseUser();
        user.setUsername(contact.getUserName());
        user.setPassword(contact.getUserPassword());
        user.setEmail(contact.getUserEmail());


        // other fields can be set just like with ParseObject
        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(com.parse.ParseException e) {

            }

            public void done(ParseException e) {
                if (e == null) {
                    // Hooray! Let them use the app now.
                } else {
                    // Sign up didn't succeed. Look at the ParseException
                    // to figure out what went wrong
                }
            }
        });

        return user;
    }
}
