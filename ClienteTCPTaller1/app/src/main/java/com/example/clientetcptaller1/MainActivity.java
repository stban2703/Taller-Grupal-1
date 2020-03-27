package com.example.clientetcptaller1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ComunicacionTCP comm;
    private ImageButton izquierdabtn;
    private ImageButton derechabtn;
    private ImageButton poderbtn;

    boolean isLEFT = true;
    boolean isRIGHT = true;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        comm = new ComunicacionTCP(this);
        comm.solicitarConexion();

        izquierdabtn = findViewById(R.id.izquierdabtn);
        derechabtn = findViewById(R.id.derechabtn);
        poderbtn = findViewById(R.id.poderbtn);

        izquierdabtn.setOnTouchListener(
                (v, event) -> {

                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            isLEFT = false;
                            //accionUp.setText("DOWN");
                            break;

                        case MotionEvent.ACTION_MOVE:
                            //accionUp.setText("MOVE");
                            break;

                        case MotionEvent.ACTION_UP:
                            isLEFT = true;
                            //accionUp.setText("UP");
                            break;
                    }
                    return true;
                }
        );

        derechabtn.setOnTouchListener(
                (v, event) -> {

                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN:
                            isRIGHT = false;
                            //accionUp.setText("DOWN");
                            break;

                        case MotionEvent.ACTION_MOVE:
                            //accionUp.setText("MOVE");
                            break;

                        case MotionEvent.ACTION_UP:
                            isRIGHT = true;
                            //accionUp.setText("UP");
                            break;
                    }
                    return true;
                }
        );

        poderbtn.setOnClickListener(
                (v) -> {
                    new Thread(
                            () -> {
                                try {
                                    Thread.sleep(60);
                                    comm.mandarMensaje("DESLIZAR");
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }

                    ).start();
                }
        );

        new Thread(
                () -> {
                    while (true) {
                        while (isLEFT) {
                        }
                        try {
                            Thread.sleep(100);
                            comm.mandarMensaje("IZQUIERDA");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
        ).start();

        new Thread(
                () -> {
                    while (true) {
                        while (isRIGHT) {
                        }
                        try {
                            Thread.sleep(100);
                            comm.mandarMensaje("DERECHA");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
        ).start();

    }

    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        //This is used to hide/show 'Status Bar' & 'System Bar'. Swip bar to get it as visible.
        View decorView = getWindow().getDecorView();
        if (hasFocus) {
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

}
