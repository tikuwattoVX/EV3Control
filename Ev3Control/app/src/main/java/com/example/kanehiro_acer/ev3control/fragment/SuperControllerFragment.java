package com.example.kanehiro_acer.ev3control.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kanehiro_acer.ev3control.R;

/**
 * Created by masakisakamoto on 2015/07/12.
 */
public class SuperControllerFragment extends Fragment {

    private View view;

    public SuperControllerFragment() {}

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_super_controller, null);
        return view;
    }
}
