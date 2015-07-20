package com.example.kanehiro_acer.ev3control.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.kanehiro_acer.ev3control.BTCommunicator;
import com.example.kanehiro_acer.ev3control.MainFragmentActivity;
import com.example.kanehiro_acer.ev3control.R;

/**
 * Created by masakisakamoto on 2015/07/12.
 */
public class NormalControllerFragment extends Fragment {

    public static final int SPEED = 50;

    private MainFragmentActivity context;
    private RelativeLayout tutorial;
    private MediaPlayer mp;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_normal_controller, null);
        this.context = (MainFragmentActivity) getActivity();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        // レイアウトの取得
        tutorial = (RelativeLayout) view.findViewById(R.id.tutorial);
        tutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tutorial.setVisibility(View.GONE);
            }
        });

        // 十字キーの処理
        Button topBtn = (Button) view.findViewById(R.id.topBtn);
        topBtn.setOnClickListener(new TopBtnClick());
        Button bottomBtn = (Button) view.findViewById(R.id.bottomBtn);
        bottomBtn.setOnClickListener(new BottomBtnClick());
        Button rightBtn = (Button) view.findViewById(R.id.rightBtn);
        rightBtn.setOnClickListener(new RightBtnClick());
        Button leftBtn = (Button) view.findViewById(R.id.leftBtn);
        leftBtn.setOnClickListener(new LeftBtnClick());


        // ボタンの処理
        Button buttonA = (Button) view.findViewById(R.id.buttonA);
        buttonA.setOnClickListener(new ButtonAClick());
        Button buttonB = (Button) view.findViewById(R.id.buttonB);
        buttonB.setOnClickListener(new ButtonBClick());
        Button buttonStart = (Button) view.findViewById(R.id.startButton);
        buttonStart.setOnClickListener(new ButtonStartClick());
        Button buttonSelect = (Button) view.findViewById(R.id.selectButton);
        buttonSelect.setOnClickListener(new ButtonSelectClick());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ダイアログを表示する
//        DialogFragment newFragment = new CustomMenuDialogFragment();
//        newFragment.show(getFragmentManager(), "custom");
    }

    /*======================== 十字キークリック処理 start ===========================*/
    private class TopBtnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            goForward(SPEED);
        }
    }

    private class BottomBtnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            goBackward(SPEED);
        }
    }

    private class RightBtnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            motorBon(SPEED);
            motorCoff();
        }
    }

    private class LeftBtnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            motorCon(SPEED);
            motorBoff();
        }
    }

    /*======================== 十字キークリック処理 finish ===========================*/

    /*======================== ボタンクリック処理 start ===========================*/
    private class ButtonAClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            stopMove();
        }
    }

    private class ButtonBClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {

        }
    }

    private class ButtonStartClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            // TODO Startボタン処理を記述
            tutorial.setVisibility(View.VISIBLE);
        }
    }

    private class ButtonSelectClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            // TODO Selectボタン処理を記述
//            new CustomMenuDialogFragment().onCreateDialog(new Bundle());
        }
    }
    /*======================== ボタンクリック処理 finish ===========================*/

    private void playTone(int frequency, int duration) {
        context.sendBTCmessage(BTCommunicator.NO_DELAY, BTCommunicator.PLAYTONE, frequency, duration);
    }

    private void showPicture() {
        context.sendBTCmessage(BTCommunicator.NO_DELAY, BTCommunicator.SHOWPICTURE);
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

    private void motorAon(int speed) {
        context.sendBTCmessage(BTCommunicator.NO_DELAY, BTCommunicator.ROTATE_MOTOR_A, speed);
    }

    private void motorAoff() {
        context.sendBTCmessage(BTCommunicator.NO_DELAY, BTCommunicator.STOP_MOTOR_A);
    }

    private void motorBon(int speed) {
        context.sendBTCmessage(BTCommunicator.NO_DELAY, BTCommunicator.ROTATE_MOTOR_B, speed);
    }

    private void motorBoff() {
        context.sendBTCmessage(BTCommunicator.NO_DELAY, BTCommunicator.STOP_MOTOR_B);
    }

    private void motorCon(int speed) {
        context.sendBTCmessage(BTCommunicator.NO_DELAY, BTCommunicator.ROTATE_MOTOR_C, speed);
    }

    private void motorCoff() {
        context.sendBTCmessage(BTCommunicator.NO_DELAY, BTCommunicator.STOP_MOTOR_C);
    }

    private void rotateByDegree(int speed, int degree) {
        context.sendBTCmessage(BTCommunicator.NO_DELAY, BTCommunicator.GO_FORWARD_DEGREE, speed, degree);
    }

    private void rotateByTime(int speed, int time) {
        context.sendBTCmessage(BTCommunicator.NO_DELAY, BTCommunicator.GO_FORWARD_TIME, speed, time);
    }

    private void readColorSensor(int port) {
        context.sendBTCmessage(BTCommunicator.NO_DELAY, BTCommunicator.READ_COLOR_SENSOR, port);
    }

    private void readTouchSensor(int port) {
        context.sendBTCmessage(BTCommunicator.NO_DELAY, BTCommunicator.READ_TOUCH_SENSOR, port);
    }

    private void readUltrasonicSensor(int port) {
        context.sendBTCmessage(BTCommunicator.NO_DELAY, BTCommunicator.READ_USONIC_SENSOR, port);
    }

    public static class CustomMenuDialogFragment extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

            LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View content = inflater.inflate(R.layout.normal_dialog_setting, null);

            builder.setView(content);

            builder.setMessage("設定")
                    .setNegativeButton("閉じる", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // User cancelled the dialog
                        }
                    });
            // Create the AlertDialog object and return it
            return builder.create();
        }
    }
}
