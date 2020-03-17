package com.example.clientetcptaller1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ComunicacionTCP comm;
    //Button izquierdabtn;
    //Button derechabtn;
    //Button poderbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //izquierdabtn.findViewById(R.id.izquierdabtn);
        //derechabtn.findViewById(R.id.derechabtn);
        //poderbtn.findViewById(R.id.poderbtn);

        comm=new ComunicacionTCP(this);
        comm.solicitarConexion();

    }
}
