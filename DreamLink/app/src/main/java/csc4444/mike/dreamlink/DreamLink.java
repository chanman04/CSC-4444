package csc4444.mike.dreamlink;

import android.app.Application;

import com.parse.Parse;

/**
 * Created by Mike on 9/22/15.
 */
public class DreamLink extends Application {

    @Override
    public void onCreate(){
        super.onCreate();
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "EZZtXXc6TYVQdpb4RqMCuRtvMT9TU35fnwBhygFP", "U2Mge5DRDu5Q3ZftP1Fi4Y5C8SICfMurNf3fCrRr");


    }
}
