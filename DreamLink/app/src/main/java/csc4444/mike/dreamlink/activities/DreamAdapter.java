package csc4444.mike.dreamlink.activities;

import csc4444.mike.dreamlink.R;
import csc4444.mike.dreamlink.components.Dream;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by milesrobicheaux on 10/16/15.
 */
public class DreamAdapter extends ArrayAdapter<Dream> {
    static Context context;
    static int layoutResourceId;
    //List<Dream> data = new Stack<>();
    List<Dream> data = new ArrayList<Dream>();

    public DreamAdapter(Context context, int layoutResourceId, List<Dream> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }


    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        DreamHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            //row.setMinimumHeight(200);
            holder = new DreamHolder();
            holder.dreamTitle = (TextView)row.findViewById(R.id.dreamTitle);
            holder.dreamEntry = (TextView)row.findViewById(R.id.dreamEntry);

            row.setTag(holder);
        }
        else
        {
            holder = (DreamHolder)row.getTag();
        }

        Dream dream = data.get(position);
        holder.dreamTitle.setText(dream.getTitle());
        holder.dreamEntry.setText(dream.getEntry());

        return row;
    }

    static class DreamHolder
    {
        TextView dreamTitle;
        TextView dreamEntry;
    }

}
