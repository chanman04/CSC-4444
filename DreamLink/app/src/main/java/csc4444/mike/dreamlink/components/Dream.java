package csc4444.mike.dreamlink.components;

/**
 * Created by Mike on 10/14/15.
 */
public class Dream {

    private String dreamTitle;
    private String dreamEntry;


    public Dream(){
        super();
    }
    public Dream(String dreamTitle, String dreamEntry){
        super();
        this.dreamTitle = dreamTitle;
        this.dreamEntry = dreamEntry;
    }
    public String getTitle(){
        return dreamTitle;
    }
    public String getEntry(){
        return dreamEntry;
    }
    public void setTitle(String dreamTitle){
        this.dreamTitle = dreamTitle;
    }
    public void setEntry(String dreamEntry){
        this.dreamEntry = dreamEntry;
    }

}
