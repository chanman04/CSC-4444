package csc4444.mike.dreamlink;

import android.app.Application;
import android.content.Context;

import com.parse.Parse;

/**
 * Created by Mike on 9/22/15.
 */
public class DreamLink extends Application {

    private String username;
    private static DreamLink singleInstance = null;


    public String getUsername() {
        return username;
    }

    public void setWagerLogLV(String user) {
        this.username = user;
    }

    public static DreamLink getInstance()
    {
        return singleInstance;
    }

    public Context getContext(){
            return singleInstance;
    }


    @Override
    public void onCreate(){
        super.onCreate();
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "EZZtXXc6TYVQdpb4RqMCuRtvMT9TU35fnwBhygFP", "U2Mge5DRDu5Q3ZftP1Fi4Y5C8SICfMurNf3fCrRr");

    }
}
