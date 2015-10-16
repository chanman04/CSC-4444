package csc4444.mike.dreamlink.components;

/**
 * Created by Mike on 10/14/15.
 */
public class Dream {

    private String dreamTitle;
    private String dreamEntry;


    public Dream(){

    }
    public Dream(String title, String entry){
        this.dreamTitle = title;
        this.dreamEntry = entry;
    }
    public String getTitle(){
        return dreamTitle;
    }
    public String getEntry(){
        return dreamTitle;
    }
    public void setTitle(String title){
        this.dreamTitle = title;
    }
    public void setEntry(String entry){
        this.dreamEntry = entry;
    }

}
