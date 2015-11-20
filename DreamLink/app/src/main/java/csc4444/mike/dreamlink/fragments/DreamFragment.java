package csc4444.mike.dreamlink.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import csc4444.mike.dreamlink.R;

/**
 * Created by Mike on 11/4/15.
 */
public class DreamFragment extends Fragment {

    @Bind(R.id.dream_title_frag) TextView dreamTitle;
    @Bind(R.id.dream_entry_frag) TextView dreamEntry;
    @Bind(R.id.user_icon) ImageView userIcon;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dream, container, false);
    }


}
