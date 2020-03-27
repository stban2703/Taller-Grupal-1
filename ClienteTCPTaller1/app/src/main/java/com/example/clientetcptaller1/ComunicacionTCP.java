package com.example.clientetcptaller1;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ComunicacionTCP extends Thread {
    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;
    private AppCompatActivity app;

    public ComunicacionTCP(AppCompatActivity app){

        this.app=app;
    }

    public void run() {
        try {
            this.socket=new Socket("10.0.2.2",5000);


            InputStream is=socket.getInputStream();
            InputStreamReader isr=new InputStreamReader(is);
            this.reader=new BufferedReader(isr);

            OutputStream os=socket.getOutputStream();
            OutputStreamWriter osw=new OutputStreamWriter(os);
            this.writer=new BufferedWriter(osw);

            while(true) {
                recibirMensaje();
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void solicitarConexion() {

        this.start();
    }

    public void mandarMensaje(String mensaje) {
        new Thread(
                ()->{
                    try {
                        writer.write(mensaje+"\n");
                        writer.flush();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
        ).start();
    }

    public void recibirMensaje() throws IOException {
        String line=reader.readLine();
        System.out.println("<<<"+line);


    }

    public void cerrarConexion() {
        try {
            socket.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
