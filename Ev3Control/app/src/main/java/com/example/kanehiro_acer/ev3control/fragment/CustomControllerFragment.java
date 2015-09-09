package com.example.kanehiro_acer.ev3control.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.example.kanehiro_acer.ev3control.BTCommunicator;
import com.example.kanehiro_acer.ev3control.MainFragmentActivity;
import com.example.kanehiro_acer.ev3control.R;

/**
 * Created by masakisakamoto on 2015/07/12.
 */
public class CustomControllerFragment extends Fragment {

    private MainFragmentActivity context;

    public CustomControllerFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_custom_controller, null);
        this.context = (MainFragmentActivity) getActivity();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        buttonSetting(view);

    }

    // ボタンの設定メソッド
    private void buttonSetting(View view) {
        BootstrapButton greenBtn = (BootstrapButton) view.findViewById(R.id.green_button);
        greenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 3秒前進して止まる
                rotateByTime(50, 3000);
            }
        });
        BootstrapButton blueBtn = (BootstrapButton) view.findViewById(R.id.blue_button);
        blueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 壁に近づいたら止まる

            }
        });
        BootstrapButton yellowBtn = (BootstrapButton) view.findViewById(R.id.yellow_button);
        yellowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 黒くなったら止まる

            }
        });
        BootstrapButton redBtn = (BootstrapButton) view.findViewById(R.id.red_button);
        redBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 90度曲がる

            }
        });
    }

    private void rotateByTime(int speed, int time) {
        context.sendBTCmessage(BTCommunicator.NO_DELAY, BTCommunicator.GO_FORWARD_TIME, speed, time);
    }

    private void stopMove() {
        context.sendBTCmessage(BTCommunicator.NO_DELAY, BTCommunicator.STOP_MOVE);
    }

    private void goForward(int speed) {
        context.sendBTCmessage(BTCommunicator.NO_DELAY, BTCommunicator.GO_FORWARD, speed);
    }

    private void goBackward(int speed) {
        context.sendBTCmessage(BTCommunicator.NO_DELAY, BTCommunicator.GO_BACKWARD, speed);
    }
}
