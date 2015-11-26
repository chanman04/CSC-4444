package csc4444.mike.dreamlink.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

import csc4444.mike.dreamlink.R;

/**
 * Created by Mike on 11/25/15.
 */
public class DictionaryAdapter extends ParseQueryAdapter<ParseObject> {

    public DictionaryAdapter(Context context, final String userName){
        super(context, new ParseQueryAdapter.QueryFactory<ParseObject>(){
            public ParseQuery create(){
                ParseQuery query = new ParseQuery("DREAM_DICT");
                //query.whereEqualTo("USER", userName); //username not yet linked to dreams on parse?
//                query.whereEqualTo("test", true);
                return query;
            }
        });
    }

    @Override
    public View getItemView(ParseObject object, View v, ViewGroup parent){
        if(v == null) {
            v = View.inflate(getContext(), R.layout.dictionary_adapter_layout, null);
        }

        super.getItemView(object, v, parent);

        // Add the title view
        TextView titleTextView = (TextView) v.findViewById(R.id.dreamTitle);
        titleTextView.setText(object.getString("DREAM_TERM"));

        //Add the entry view
//        TextView entryTextView = (TextView) v.findViewById(R.id.dreamEntry);
//        entryTextView.setText(object.getString("DREAM_ENTRY"));

        return v;
    }
}
