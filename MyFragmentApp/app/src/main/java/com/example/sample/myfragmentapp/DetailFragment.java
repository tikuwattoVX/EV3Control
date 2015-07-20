package com.example.sample.myfragmentapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by masakisakamoto on 2015/07/20.
 */
public class DetailFragment extends Fragment {

    public DetailFragment() {}

    static DetailFragment newInstance(int position) {
        DetailFragment detailFragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        detailFragment.setArguments(args);
        return detailFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View detailView = inflater.inflate(R.layout.view_detail, container, false);
        TextView textView = (TextView) detailView.findViewById(R.id.detailText);
        textView.setText(News.Details[getArguments().getInt("position")]);
        return detailView;
    }
}
